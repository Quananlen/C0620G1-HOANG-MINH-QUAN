import java.util.Scanner;

public class SumDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input length of matrix");
        int length = scanner.nextInt();
        int[][] array = new int[length][length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.println("input for row " + (i+1) + " and column " + (j+1));
                int value = scanner.nextInt();
                array[i][j] = value;
            }
        }
        for (int[] row : array) {
            for (int j : row) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < length; i++) {
            sum += array[i][i];
        }
        System.out.println("sum of main diagonal is " + sum);
    }
}
