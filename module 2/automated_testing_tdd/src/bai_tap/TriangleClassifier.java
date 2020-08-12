package bai_tap;

public class TriangleClassifier {
    public static String TriangleClassifier(int firstSide, int secondSide, int thirdSide) {
        boolean isTriangle = firstSide + secondSide > thirdSide && firstSide + thirdSide > secondSide && secondSide + thirdSide > firstSide;
        boolean isEquilateral = firstSide == secondSide && firstSide == thirdSide;
        boolean isIsosceles = firstSide == secondSide || firstSide == thirdSide || secondSide == thirdSide;
        if (isTriangle) {
            if (isEquilateral) return "equilateral triangle";
            if (isIsosceles) return "isosceles triangle";
            return "scalene triangle";
        }
        return "not a triangle";
    }
}
