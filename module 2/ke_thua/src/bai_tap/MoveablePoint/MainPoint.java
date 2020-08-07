package bai_tap.MoveablePoint;

public class MainPoint {
    public static void main(String[] args) {
        Point point = new Point(5,10);
        MoveablePoint moveablePoint = new MoveablePoint(10,15,10,15);
        System.out.println(point.toString());
        System.out.println(moveablePoint.toString());
        moveablePoint.move();
        System.out.println(moveablePoint.toString());
    }
}
