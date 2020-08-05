import java.util.*;
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int random = rnd.nextInt(100001);
            arr[i] = random;
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(stopWatch.getStartTime());
        Arrays.sort(arr);
        stopWatch.end();
        long elapsedTime = stopWatch.getElapsedTime();
        System.out.println("sorting time: " + elapsedTime);
    }
}
