package bai_tap;

public class TreeNodeBT {
    protected int element;
    protected TreeNodeBT left;
    protected TreeNodeBT right;

    public TreeNodeBT(int e) {
        element = e;
    }

    @Override
    public String toString() {
        return "TreeNodeBT{" +
                "element=" + element +
                '}';
    }
}
