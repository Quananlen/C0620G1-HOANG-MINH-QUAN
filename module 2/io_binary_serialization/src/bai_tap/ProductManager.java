package bai_tap;

import java.io.*;
import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        try {
            displayMenu();
        } catch (IOException e) {
            System.err.println("Something wrong");
        }
    }

    public static void displayMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("1. Add product" + "\n" +
                "2. Display product" + "\n" +
                "3. Find product" + "\n" +
                "4. Exit");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addProduct();
                displayMenu();
                break;
            case 2:
                displayProduct();
                displayMenu();
                break;
            case 3:
                findProduct();
                displayMenu();
                break;
            case 4:
                return;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static void findProduct() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("find product by:" + "\n" +
                "1. id" + "\n" +
                "2. name" + "\n" +
                "3. manufacturer" + "\n" +
                "4. price");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("input id");
                String id = scanner.next();
                if (printItem(id) != null) System.out.println(printItem(id));
                else System.out.println("Cant find product by id " + id);
                break;
            case 2:
                System.out.println("input name");
                String name = scanner.next();
                if (printItem(name) != null) System.out.println(printItem(name));
                else System.out.println("Cant find product by name " + name);
                break;
            case 3:
                System.out.println("input manufacturer");
                String manufacturer = scanner.next();
                if (printItem(manufacturer) != null) System.out.println(printItem(manufacturer));
                else System.out.println("Cant find product by manufacturer " + manufacturer);
                break;
            case 4:
                System.out.println("input price");
                String price = scanner.next();
                if (printItem(price) != null) System.out.println(printItem(price));
                else System.out.println("Cant find product by price " + price);
                break;
        }
    }

    private static String printItem(String item) throws IOException {
        FileReader fileReader = new FileReader("product.csv");
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(item)) {
                return line;
            }
        }
        return null;
    }

    private static void displayProduct() throws IOException {
        FileReader is = new FileReader("product.csv");
        BufferedReader isbuff = new BufferedReader(is);
        String line;
        while ((line = isbuff.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void addProduct() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input product id");
        int id = scanner.nextInt();
        System.out.println("Input product name");
        String name = scanner.next();
        System.out.println("Input manufacturer");
        String manufacturer = scanner.next();
        System.out.println("Input price");
        double price = scanner.nextDouble();
        Product product = new Product(id, name, manufacturer, price);
        writeProduct(product);
    }

    private static void writeProduct(Product product) throws IOException {
        String[] array = product.toString().split(",");
        try (
                FileWriter is = new FileWriter("product.csv", true);
        ) {
            for (int i = 0; i < array.length; i++) {
                is.append(array[i]);
                if (i != array.length - 1) is.append(",");
                else is.append("\n");
            }
        }
    }
}
