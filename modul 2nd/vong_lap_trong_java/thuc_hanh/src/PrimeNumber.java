import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number to check prime");
        int num = scanner.nextInt();
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0) {
                System.out.printf("%d is not prime", num);
                return;
            }
        }
        System.out.printf("%d is prime", num);
    }
}
