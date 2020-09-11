import java.util.LinkedList;
import java.util.Queue;

public class bai_1 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(getFirst(queue, 6));
    }

    public static int getFirst(Queue<Integer> queue, int num) {
        for (int i = 0; i < num-1; i++) {
            int first = queue.poll();
            queue.offer(first);
            queue.offer(first);
        }
        return queue.poll();
    }
}
