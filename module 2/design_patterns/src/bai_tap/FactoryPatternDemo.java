package bai_tap;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Circle circle = (Circle) shapeFactory.createShape("Circle");
        circle.draw();
        Square square = (Square) shapeFactory.createShape("Square");
        square.draw();
        Rectangle rectangle = (Rectangle) shapeFactory.createShape("Rectangle");
        rectangle.draw();
    }
}
