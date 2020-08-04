import java.util.Scanner;
import java.util.Arrays;
public class InsertToArray {
    public static void main(String[] args) {
        int[] arr = {10,4,6,7,8,0,0,0,0,0};
        System.out.printf("Array elements: %s \n", Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.println("input value and index to insert");
        System.out.println("value");
        int value = scanner.nextInt();
        System.out.println("index");
        int index = scanner.nextInt();
        insertToArray(arr, value, index);
        System.out.printf("Array elements: %s \n", Arrays.toString(arr));
    }
    public static int[] insertToArray(int[] arr, int value, int index) {
        for (int i = arr.length-1; i >= index; i--) {
            arr[i] = arr[i-1];
            if (i==index) arr[i] = value;
        }
        return arr;
    }
}
