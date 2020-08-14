package bai_tap;

import org.junit.jupiter.api.Test;

import static bai_tap.CheckBracket.checkBracket;
import static org.junit.jupiter.api.Assertions.*;

class CheckBracketTest {

    @Test
    void checkBracket1() {
        String str = "s * (s – a) * (s – b) * (s – c)";
        boolean expect = true;
        boolean result = checkBracket(str);
        assertEquals(expect, result);
    }
    @Test
    void checkBracket2() {
        String str = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        boolean expect = true;
        boolean result = checkBracket(str);
        assertEquals(expect, result);
    }
    @Test
    void checkBracket3() {
        String str = "s * (s – a) * (s – b * (s – c)";
        boolean expect = false;
        boolean result = checkBracket(str);
        assertEquals(expect, result);
    }
    @Test
    void checkBracket4() {
        String str = "s * (s – a) * s – b) * (s – c)";
        boolean expect = false;
        boolean result = checkBracket(str);
        assertEquals(expect, result);
    }
    @Test
    void checkBracket5() {
        String str = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        boolean expect = true;
        boolean result = checkBracket(str);
        assertEquals(expect, result);
    }


}