import  java.util.*;
public class SumColumnArray {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        for (int[] row : arr) {
            for (int j : row) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input column to find sum");
        int column = scanner.nextInt()-1;
        for (int[] i : arr) {
            sum+= i[column];
        }
        System.out.println("sum is " + sum);
    }
}
