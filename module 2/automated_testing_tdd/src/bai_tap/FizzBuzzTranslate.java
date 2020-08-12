package bai_tap;

public class FizzBuzzTranslate {
    public static String FizzBuzzTranslate(int num) {
        if (num < 100) {
            return getFizzBuzz(num);
        }
        return "is over 99";
    }

    public static String getFizzBuzz(int num) {
        boolean isDividedBy3 = num % 3 == 0;
        boolean isDividedBy5 = num % 5 == 0;
        boolean contain3 = 30 <= num && num <= 39 || num % 10 == 3;
        boolean contain5 = 50 <= num && num <= 59 || num % 10 == 5;
        if (isDividedBy3 && isDividedBy5) return "FizzBuzz";
        if (isDividedBy3) return "Fizz";
        if (isDividedBy5) return "Buzz";
        if (contain3) return "Fizz";
        if (contain5) return "Buzz";
        return readNum(num);
    }

    public static String readNum(int num) {
        int ten = num / 10;
        int one = num % 10;
        if (num < 10) return getLabel(one);
        return getLabel(ten) + getLabel(one);
    }

    public static String getLabel(int num) {
        switch (num) {
            default:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
    }
}
