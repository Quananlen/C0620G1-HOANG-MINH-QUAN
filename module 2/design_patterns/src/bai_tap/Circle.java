package bai_tap;

public class Circle implements Shape{
    Shape shape;

    @Override
    public void draw() {
        System.out.println("Circle drawn");
    }

    Shape createShape() {
        return this.shape;
    }
}
