package bai_tap;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 5, 7, 11, 13, 17, 19, 23};
        int result = binarySearch(13, arr, 0, 10);
        if (result == -1) System.out.println("not found");
        else System.out.println("index: " + result);
    }

    public static int binarySearch(int x, int[] arr, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) return mid;
            if (x > arr[mid]) return binarySearch(x, arr, mid + 1, right);
            else return binarySearch(x, arr, left, mid - 1);
        }
        return -1;
    }
}
