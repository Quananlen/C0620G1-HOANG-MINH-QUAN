package bai_tap.Circle;

public class Cylinder extends Circle {

    private double height;

    public Cylinder(){}

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume(){
        return this.getArea()*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", radius=" + getRadius() +
                ", color=" + getColor() +
                '}';
    }
}
