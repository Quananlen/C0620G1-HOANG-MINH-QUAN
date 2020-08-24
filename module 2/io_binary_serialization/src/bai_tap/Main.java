package bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
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
                break;
            case 2:
                displayProduct();
                break;
            case 3:
                findProduct();
                break;
            case 4:
                return;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static void findProduct() {
    }

    private static void displayProduct() throws IOException {
        FileReader is = new FileReader("product.csv");
        BufferedReader isbuff = new BufferedReader(is);
        String line;
        System.out.println("ID, name, manufacturer, price");
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
