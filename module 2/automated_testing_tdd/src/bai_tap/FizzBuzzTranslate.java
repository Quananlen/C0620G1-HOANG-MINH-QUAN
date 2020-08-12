package bai_tap;

public class FizzBuzzTranslate {
    public static String FizzBuzzTranslate(int num) {
        String result = "";
        if (num < 100) {
            for (int i = 1; i <= num; i++) {
                result += getFizzBuzz(i) + " ";
            }
            return result;
        }
        return "is over 99";
    }

    public static String getFizzBuzz(int num) {
        boolean isDividedBy3 = num % 3 == 0;
        boolean isDividedBy5 = num % 5 == 0;
        if (isDividedBy3 && isDividedBy5) return "FizzBuzz";
        if (isDividedBy3) return "Fizz";
        if (isDividedBy5) return "Buzz";
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
