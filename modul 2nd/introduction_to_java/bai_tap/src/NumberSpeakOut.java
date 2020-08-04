import java.util.Scanner;

public class NumberSpeakOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number");
        int number = scanner.nextInt();
        String str = "";
        int hundred = (int) Math.floor(number / 100);
        int temp = number % 100;
        int ten = (int) Math.floor(temp / 10);
        int one = number % 10;
        if (0 < number && number < 20) {
            switch (number) {
                case 1 -> str = "one";
                case 2 -> str = "two";
                case 3 -> str = "three";
                case 4 -> str = "four";
                case 5 -> str = "five";
                case 6 -> str = "six";
                case 7 -> str = "seven";
                case 8 -> str = "eight";
                case 9 -> str = "nine";
                case 10 -> str = "ten";
                case 11 -> str = "eleven";
                case 12 -> str = "twelve";
                case 13 -> str = "thirteen";
                case 14 -> str = "fourteen";
                case 15 -> str = "fifteen";
                case 16 -> str = "sixteen";
                case 17 -> str = "seventeen";
                case 18 -> str = "eighteen";
                case 19 -> str = "nineteen";
            }
        }
        if (20 < number && number < 1000) {
            switch (hundred) {
                case 2 -> str = "two hundred";
                case 3 -> str = "three hundred";
                case 4 -> str = "four hundred";
                case 5 -> str = "five hundred";
                case 6 -> str = "six hundred";
                case 7 -> str = "seven hundred";
                case 8 -> str = "eight hundred";
                case 9 -> str = "nine hundred";
            }
            if (ten != 0 && one != 0) str += " and";
            if (ten != 1) {
                switch (ten) {
                    case 2 -> str += " twenty";
                    case 3 -> str += " thirty";
                    case 4 -> str += " forty";
                    case 5 -> str += " fifty";
                    case 6 -> str += " sixty";
                    case 7 -> str += " seventy";
                    case 8 -> str += " eighty";
                    case 9 -> str += " ninety";
                }
                switch (one) {
                    case 1 -> str += " one";
                    case 2 -> str += " two";
                    case 3 -> str += " three";
                    case 4 -> str += " four";
                    case 5 -> str += " five";
                    case 6 -> str += " six";
                    case 7 -> str += " seven";
                    case 8 -> str += " eight";
                    case 9 -> str += " nine";
                }
            } else switch (one) {
                case 0 -> str += " ten";
                case 1 -> str += " eleven";
                case 2 -> str += " twelve";
                case 3 -> str += " thirteen";
                case 4 -> str += " fourteen";
                case 5 -> str += " fifteen";
                case 6 -> str += " sixteen";
                case 7 -> str += " seventeen";
                case 8 -> str += " eighteen";
                case 9 -> str += " nineteen";
            }
        }
        System.out.println(str);
    }
}
