public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<Integer>(10);
        // Test add
        integerMyList.add(0, 20);
        integerMyList.add(1, 40);
        integerMyList.add(2, 60);
        integerMyList.add(3, 80);
        integerMyList.add(4, 100);
        System.out.println(integerMyList.get(0));
        System.out.println(integerMyList.get(1));
        System.out.println(integerMyList.get(2));
        System.out.println(integerMyList.get(3));
        System.out.println(integerMyList.get(4));
        // Test checkIndex
        System.out.println(integerMyList.get(5));
        System.out.println(integerMyList.get(6));
        System.out.println(integerMyList.get(50));
    }
}