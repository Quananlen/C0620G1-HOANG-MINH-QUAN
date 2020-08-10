package bai_tap;

public class Square extends thuc_hanh.Comparator.Square implements Colorable{
    public Square() {
    }

    public Square(double side) {
        super(side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
