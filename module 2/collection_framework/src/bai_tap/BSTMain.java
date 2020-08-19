package bai_tap;


public class BSTMain {
    public static void main(String[] args) {
        BSTBT tree = new BSTBT();
        tree.insert(5);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);
        tree.insert(3);
        tree.insert(2);
        tree.insert(8);
        tree.insert(6);
        tree.inOrder();
        System.out.println("---delete---");
        tree.delete(3);
        tree.inOrder();
        System.out.println(tree.search(9));
    }

}
