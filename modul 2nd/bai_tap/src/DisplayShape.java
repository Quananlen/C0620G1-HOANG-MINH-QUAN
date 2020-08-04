import java.util.Scanner;

public class DisplayShape {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                    1. Print the rectangle                                   
                    2. Print the square triangle                                      
                    3. Print isosceles triangle                                        
                    4. Exit""");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("*".repeat(7));
                    }
                }
                case 2 -> {
                    for (int i = 1; i < 6; i++) {
                        System.out.println("*".repeat(i));
                    }
                }
                case 3 -> {
                    String result = "";
                    for (int i = 0; i < 6; i++) {
                        result += " ".repeat(5-i);
                        result += "*".repeat(i*2 +1);
                        System.out.println(result);
                        result = "";
                    }
                }
            }
        } while (choice != 4);
    }
}
