package bai_tap;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("side 1");
            int side1 = scanner.nextInt();
            if (side1 <= 0) throw new IllegalArgumentException();

            System.out.println("side 2");
            int side2 = scanner.nextInt();
            if (side2 <= 0) throw new IllegalArgumentException();

            System.out.println("side 3");
            int side3 = scanner.nextInt();
            if (side3 <= 0) throw new IllegalArgumentException();

            if (side1 + side2 <side3 || side1 + side3 < side2 || side2+ side3 < side1) throw new IllegalTriangleException("Ko phải là tam giác");

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Ko phải là số nguyên");
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("Ko phải là số dương");
        }
    }
}
