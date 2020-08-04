import java.util.Arrays;
public class ConcatArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9,0};
        int[] arr3 = Arrays.copyOf(arr1, arr1.length+ arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length+i] = arr2[i];
        }
        System.out.println(Arrays.toString(arr3));
    }
}
