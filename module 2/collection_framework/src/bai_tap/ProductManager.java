package bai_tap;

import java.util.*;

public class ProductManager {
    public static ArrayList<Product> arrProduct = new ArrayList<>();
    public static LinkedList<Product> linkedProduct = new LinkedList<>();

    public static void edit(int id, String name, int price) {
        for (Product item : arrProduct) {
            if (item.getId() == id) {
                item.setName(name);
                item.setPrice(price);
                break;
            }
        }
    }

    public static String searchByName(String name) {
        for (Product item : arrProduct) {
            if (item.getName().equals(name)) return item.toString();
        }
        return "No product";
    }

    public static void main(String[] args) {
        Product ferrari = new Product("Ferrari", 1, 700);
        Product lamborghini = new Product("Lamborghini", 2, 650);
        Product porsche = new Product("Porsche", 3, 400);
        Product mercedes = new Product("Mercedes", 4, 350);
        Product astonMartin = new Product("Aston Martin", 5, 500);
        arrProduct.add(ferrari);
        arrProduct.add(lamborghini);
        arrProduct.add(porsche);
        arrProduct.add(mercedes);
        arrProduct.add(astonMartin);

        System.out.println(arrProduct.get(2));
        edit(5, "Rolls Royce", 600);
        System.out.println(arrProduct.toString());
        System.out.println(searchByName("Ferrari"));

        arrProduct.sort(Comparator.comparing(Product::getName));
        System.out.println(arrProduct.toString());

        arrProduct.sort(Comparator.comparing(Product::getPrice));
        System.out.println(arrProduct.toString());

        linkedProduct.add(ferrari);
        linkedProduct.add(lamborghini);
        linkedProduct.add(porsche);
        linkedProduct.add(mercedes);
        linkedProduct.add(astonMartin);

        System.out.println(linkedProduct.get(3));
    }
}
