import java.util.Scanner;
public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input amount of money (in USD)");
        int rate = scanner.nextInt();
        int vnd = rate * 23000;
        System.out.printf("The amount of money in VND is %d", vnd);
    }
}
