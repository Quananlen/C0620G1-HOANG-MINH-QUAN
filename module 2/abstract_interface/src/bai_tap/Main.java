package bai_tap;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Square square = new Square(10);
        Rectangle rectangle = new Rectangle(10, 20);
        Shape[] array = {circle, square, rectangle};

        for (Shape shape : array) {
            System.out.println(shape);
            double percent = Math.random();
            shape.resize(percent);
            if (shape instanceof Square) ((Square) shape).howToColor();
            System.out.println(shape);
        }
    }
}
