package bai_tap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void TriangleClassifierTest222() {
        int firstSide = 2;
        int secondSide = 2;
        int thirdSide = 2;

        String expect = "equilateral triangle";
        String result = TriangleClassifier.TriangleClassifier(firstSide,secondSide,thirdSide);
        assertEquals(expect, result);
    }

    @Test
    void TriangleClassifierTest223() {
        int firstSide = 2;
        int secondSide = 2;
        int thirdSide = 3;

        String expect = "isosceles triangle";
        String result = TriangleClassifier.TriangleClassifier(firstSide,secondSide,thirdSide);
        assertEquals(expect, result);
    }

    @Test
    void TriangleClassifierTest345() {
        int firstSide = 3;
        int secondSide = 4;
        int thirdSide = 5;

        String expect = "scalene triangle";
        String result = TriangleClassifier.TriangleClassifier(firstSide,secondSide,thirdSide);
        assertEquals(expect, result);
    }

    @Test
    void TriangleClassifierTest823() {
        int firstSide = 8;
        int secondSide = 2;
        int thirdSide = 3;

        String expect = "not a triangle";
        String result = TriangleClassifier.TriangleClassifier(firstSide,secondSide,thirdSide);
        assertEquals(expect, result);
    }

    @Test
    void TriangleClassifierTestNegative121() {
        int firstSide = -1;
        int secondSide = 2;
        int thirdSide = 1;

        String expect = "not a triangle";
        String result = TriangleClassifier.TriangleClassifier(firstSide,secondSide,thirdSide);
        assertEquals(expect, result);
    }

    @Test
    void TriangleClassifierTest011() {
        int firstSide = 0;
        int secondSide = 1;
        int thirdSide = 1;

        String expect = "not a triangle";
        String result = TriangleClassifier.TriangleClassifier(firstSide,secondSide,thirdSide);
        assertEquals(expect, result);
    }
}