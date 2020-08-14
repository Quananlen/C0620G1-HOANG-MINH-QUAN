package bai_tap;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(0);
        System.out.println(queue.displayQueue());
        queue.enQueue(1);
        System.out.println(queue.displayQueue());
        queue.enQueue(2);
        System.out.println(queue.displayQueue());
        queue.enQueue(3);
        System.out.println(queue.displayQueue());
        queue.deQueue();
        System.out.println(queue.displayQueue());
    }
}
