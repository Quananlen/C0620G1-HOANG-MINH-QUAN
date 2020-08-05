import java.util.Scanner;


public class DeleteFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("input value to delete");
        int value = scanner.nextInt();
        boolean isBelong = false;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                isBelong = true;
                index = i;
                break;
            }
        }
        if (!isBelong) {
            System.out.println("There is no value in array");
        } else {
            for (int i = index; i < arr.length-1; i++) {
                arr[i] = arr[i + 1];
            }
            for (int j = 0; j < arr.length - 1; j++) {
                System.out.print(arr[j] + "\t");
            }
        }
    }
}
