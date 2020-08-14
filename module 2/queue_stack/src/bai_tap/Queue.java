package bai_tap;

public class Queue {
    public Node front;
    public Node rear;
    static public int size = 0;

    public void enQueue(int data) {
        Node node = new Node(data);
        if (front == null) {
            front = rear = node;
        } else {
            rear.link = node;
            rear = node;
        }
        rear.link = front;
        size++;
    }

    public void deQueue() {
        if (front == null) {
            throw new UnsupportedOperationException("Empty queue, cant deQueue");
        } else if (front == rear) {
            front = rear = null;
        } else {
            front = front.link;
            rear.link = front;
        }
        Queue.size--;
    }

    public String displayQueue() {
        String str = "[";
        Node temp = front;
        for (int i = 0; i < Queue.size - 1; i++) {
            str += temp.data + ", ";
            temp = temp.link;
        }
        str += rear.data + "]";
        return str;
    }

}
