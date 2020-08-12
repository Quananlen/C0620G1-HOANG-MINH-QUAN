package bai_tap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {
    @Test
    void case5() {
        int num = 5;
        String expected = "One Two Fizz Four Buzz ";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case15() {
        int num = 15;
        String expected = "One Two Fizz Four Buzz Fizz Seven Eight Fizz Buzz OneOne Fizz OneThree OneFour FizzBuzz ";

        String result = FizzBuzzTranslate.FizzBuzzTranslate(num);
        assertEquals(expected, result);
    }
    @Test
    void case30() {
        int num = 30;
        String expected = "One Two Fizz Four Buzz Fizz Seven Eight Fizz Buzz OneOne Fizz OneThree OneFour FizzBuzz OneSix OneSeven Fizz OneNine Buzz Fizz TwoTwo TwoThree Fizz Buzz TwoSix Fizz TwoEight TwoNine FizzBuzz ";

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