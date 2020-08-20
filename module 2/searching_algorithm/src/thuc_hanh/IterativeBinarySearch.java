package thuc_hanh;

public class IterativeBinarySearch {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int result = binarySearch(9, arr);
        if (result == -1) System.out.println("not found");
        else System.out.println("index: " + result );
    }

    public static int binarySearch(int x, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x == arr[mid]) return mid;
            if (x > arr[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
