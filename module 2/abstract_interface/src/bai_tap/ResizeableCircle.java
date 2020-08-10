package bai_tap;

import thuc_hanh.Comparator.Circle;

public class ResizeableCircle extends Circle implements Resizeable {

    public ResizeableCircle() {
    }

    public ResizeableCircle(double radius) {
        super(radius);
    }

    public ResizeableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius()*(1+percent));
    }
}
