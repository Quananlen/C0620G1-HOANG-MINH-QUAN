package bai_tap;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNode = 0;

    static class Node {
        private Node next;
        private Object data;
        private int index;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", data=" + data +
                    '}';
        }
    }

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        numNode++;
        Node newNode = new Node(element);
        newNode.index = index;

    }

    public void addFirst(E e) {
        numNode++;
        Node newNode = new Node(e);
        newNode.index = 0;
        Node firstNode = head;
        head = newNode;
        newNode.next = firstNode;
        if (numNode == 1) tail = head;
    }

    public void addLast(E e) {
        numNode++;
        Node newNode = new Node(e);
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        tail.index = numNode-1;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", numNode=" + numNode +
                '}';
    }
}
