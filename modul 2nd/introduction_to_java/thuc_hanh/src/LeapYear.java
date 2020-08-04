import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int year;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year: ");
        year = scanner.nextInt();
        boolean isLeapYear = false;
        boolean isDivisibleBy400 = year % 400 == 0;
        boolean isNotDivisibleBy100 = year % 100 != 0;
        boolean isDivisibleBy4 = year % 4 == 0;

        if (isDivisibleBy400) isLeapYear = true;
        if (isDivisibleBy4 && isNotDivisibleBy100) isLeapYear = true;

        if (isLeapYear) System.out.printf("%d is a leap year", year);
        else System.out.printf("%d is NOT a leap year", year);
    }
}
