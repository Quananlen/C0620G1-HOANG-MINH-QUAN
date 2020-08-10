package bai_tap;

import thuc_hanh.Comparator.Circle;
import thuc_hanh.Comparator.Shape;

public class Main {

    public static void main(String[] args) {
        ResizeableCircle circle = new ResizeableCircle(10);
        ResizeableSquare square = new ResizeableSquare(10);
        ResizeableRectangle rectangle = new ResizeableRectangle(10, 20);
        Shape[] array = {circle, square, rectangle};

        for (Shape shape : array) {
            System.out.println(shape);
            double percent = Math.random();
            if (shape.getLabel().equals("Circle")) {
                ((ResizeableCircle) shape).resize(percent);
            }
            if (shape.getLabel().equals("Square")) {
                ((ResizeableSquare) shape).resize(percent);
            }
            if (shape.getLabel().equals("Rectangle"))
                ((ResizeableRectangle) shape).resize(percent);
            System.out.println(shape);
        }
    }
}
