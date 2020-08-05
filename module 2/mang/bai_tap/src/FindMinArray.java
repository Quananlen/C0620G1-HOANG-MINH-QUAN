public class FindMinArray {
    public static void main(String[] args) {
        int[] arr = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        int min = arr[0];
        for (int i : arr) {
            if (i < min) min = i;
        }
        System.out.println(min);
    }
}
