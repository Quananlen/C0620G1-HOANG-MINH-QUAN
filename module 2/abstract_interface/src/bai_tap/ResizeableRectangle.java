package bai_tap;

import thuc_hanh.Comparator.Rectangle;
import thuc_hanh.Comparator.Shape;

public class ResizeableRectangle extends Rectangle implements Resizeable{
    private double width = 1.0;
    private double length = 1.0;

    public ResizeableRectangle() {
    }

    public ResizeableRectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "ResizeableRectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }

    @Override
    public void resize(double percent) {
        setLength(getLength()*(1+percent));
        setWidth(getWidth()*(1+percent));
    }
}
