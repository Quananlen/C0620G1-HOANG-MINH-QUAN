package bai_tap;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(4);
        System.out.println(myLinkedList);
        myLinkedList.addLast(6);
        System.out.println(myLinkedList);
    }
}
