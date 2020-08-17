package bai_tap;

import java.util.TreeSet;

public class PostOrderBST {
    private static TreeSet<Integer> treeSet = new TreeSet<>();

    public void traverse() {

    }

    public static void main(String[] args) {
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        System.out.println(treeSet);
    }
}
