package thuc_hanh.Comparator;

import thuc_hanh.Comparable.ComparableCircle;

public class ComparableSquare extends Square {
    public ComparableSquare() {}

    public ComparableSquare(double side) {
        super(side);
    }

    public int compareTo(ComparableSquare r) {
        if (getSide() >= r.getSide()) return 1;
        return -1;
    }
}
