package bai_tap.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 3 sides of triangle");
        System.out.println("side 1: ");
        double side1 = scanner.nextDouble();
        System.out.println("side 2: ");
        double side2 = scanner.nextDouble();
        System.out.println("side 3: ");
        double side3 = scanner.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);
        boolean isTriangle = (side1 + side2 > side3) && (side2 + side3 > side1) && (side1 + side3 > side2);
        if (isTriangle) {
            System.out.println(triangle.toString());
            System.out.println("Triangle perimeter " + triangle.getPerimeter());
            System.out.println("Triangle area " + triangle.getArea());
        } else System.out.println("Not a triangle");
    }
}
