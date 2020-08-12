package bai_tap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {
    @Test
    void case1() {
        int num = 1;
        String expected = "One";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }

    @Test
    void case5() {
        int num = 5;
        String expected = "Buzz";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case15() {
        int num = 15;
        String expected = "FizzBuzz";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case26() {
        int num = 26;
        String expected = "TwoSix";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case30() {
        int num = 30;
        String expected = "FizzBuzz";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case31() {
        int num = 31;
        String expected = "Fizz";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case35() {
        int num = 35;
        String expected = "Buzz";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case43() {
        int num = 43;
        String expected = "Fizz";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case53() {
        int num = 58;
        String expected = "Buzz";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case58() {
        int num = 58;
        String expected = "Buzz";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case99() {
        int num = 99;
        String expected = "Fizz";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case100() {
        int num = 100;
        String expected = "is over 99";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case200() {
        int num = 200;
        String expected = "is over 99";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
}