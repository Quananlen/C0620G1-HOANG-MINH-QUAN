package bai_tap;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(10);
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.remove(3);
        System.out.println(myList);
        System.out.println(myList.indexOf(2));
        MyList<Integer> myList2 = myList.clone();
        System.out.println(myList2);
        System.out.println(myList.contains(4));
        myList2.ensureCapacity(8);
        System.out.println(myList2);
        System.out.println(myList2.get(1));
        System.out.println(myList2.get(7));
        myList.clear();
        System.out.println(myList);
    }
}
