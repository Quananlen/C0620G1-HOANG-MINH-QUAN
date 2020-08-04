import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which month that you want to count days? ");
        int month = scanner.nextInt();
        String daysInMonth;
        switch (month) {
            case 2 -> daysInMonth = "28 or 29";
            case 1,3,5,7,8,10,12 -> daysInMonth = "31";
            case 4,6,9,11 -> daysInMonth = "30";
            default -> daysInMonth = "";
        }
        if (daysInMonth != "") System.out.printf("The month '%d' has %s days!", month, daysInMonth);
        else System.out.print("Invalid input!");
    }
}
