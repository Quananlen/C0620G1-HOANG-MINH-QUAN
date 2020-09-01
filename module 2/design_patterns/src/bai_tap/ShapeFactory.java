package bai_tap;

public class ShapeFactory {
    public Shape createShape(String type) {
        switch (type) {
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            case "Rectangle":
                return new Rectangle();
        }
        return null;
    }
}
