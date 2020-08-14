package bai_tap;

import java.util.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(3);
        System.out.println(myLinkedList);

        myLinkedList.addLast(6);
        myLinkedList.addLast(7);
        System.out.println(myLinkedList);

        myLinkedList.add(1,4);
        myLinkedList.add(3,1);
        System.out.println(myLinkedList);

        myLinkedList.remove(2);
        System.out.println(myLinkedList);

        MyLinkedList<Integer> myLinkedList2 = myLinkedList.clone();
        System.out.println(myLinkedList2);

        System.out.println(myLinkedList.contains(9));
        System.out.println(myLinkedList.contains(3));

        System.out.println(myLinkedList.indexOf(4));
        System.out.println(myLinkedList.indexOf(2));

        myLinkedList.clear();
        System.out.println(myLinkedList);
    }
}
