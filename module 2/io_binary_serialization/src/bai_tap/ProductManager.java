package bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static List<Product> arrProducts = new ArrayList<>();

    public static void main(String[] args) {
        try {
            displayMenu();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayMenu() throws IOException, ClassNotFoundException {
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
//                displayProduct();
                displayArrProduct();
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
                findProductBy("id");
                break;
            case 2:
                findProductBy("name");
                break;
            case 3:
                findProductBy("manufacturer");
                break;
            case 4:
                findProductBy("price");
                break;
        }
    }

    private static void findProductBy(String str) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input " + str);
        String props = scanner.next();
        if (printItem(props) != null) System.out.println(printItem(props));
        else System.out.println("Cant find product by " + str + " " + props);
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

    public static void displayArrProduct() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("arrProduct.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Product> list = (List<Product>) objectInputStream.readObject();
        for (Product item : list) System.out.println(item);
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
        arrProducts.add(product);
        writeProduct(product);
        writeArrProduct(arrProducts);
    }

    public static void writeArrProduct(List<Product> arr) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("arrProduct.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(arr);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    private static void writeProduct(Product product) throws IOException {
        String[] array = product.toString().split(",");
        try (
                FileWriter writer = new FileWriter("product.csv", true);
        ) {
            for (int i = 0; i < array.length; i++) {
                writer.append(array[i]);
                if (i != array.length - 1) writer.append(",");
                else writer.append("\n");
            }
        }
    }
}
