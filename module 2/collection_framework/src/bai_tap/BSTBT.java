package bai_tap;

public class BSTBT {
    protected TreeNodeBT root;
    protected int size = 0;

    public int getSize() {
        return size;
    }

    protected void postOrder() {
        postOrder(root);
    }

    protected void postOrder(TreeNodeBT root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element);
    }

    protected void inOrder() {
        inOrder(root);
    }

    protected void inOrder(TreeNodeBT root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.element);
        inOrder(root.right);
    }

    protected void preOrder() {
        preOrder(root);
    }

    protected void preOrder(TreeNodeBT root) {
        if (root == null) return;
        System.out.println(root.element);
        preOrder(root.left);
        preOrder(root.right);
    }

    public boolean search(int e) {
        return search(root, e).element == e;
    }

    public TreeNodeBT search(TreeNodeBT root, int e) {
        if (root == null) return new TreeNodeBT(-1);
        if (e > root.element) return search(root.right, e);
        if (e < root.element) return search(root.left, e);
        return root;
    }

    public void insert(int e) {
        root = insertNode(root, e);
    }

    public TreeNodeBT insertNode(TreeNodeBT root, int e) {
        if (root == null) {
            root = new TreeNodeBT(e);
            return root;
        }
        if (e < root.element) root.left = insertNode(root.left, e);
        else if (e > root.element) root.right = insertNode(root.right, e);
        return root;
    }

    public void delete(int e) {
        deleteNode(root, e);
    }

    public TreeNodeBT deleteNode(TreeNodeBT root, int e) {
        size--;
        if (root == null) return root;
        if (e < root.element) {
            root.left = deleteNode(root.left, e);
        } else if (e > root.element) root.right = deleteNode(root.right, e);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.element = minValue(root.right);
            root.right = deleteNode(root.right, root.element);
        }
        return root;
    }

    public int minValue(TreeNodeBT root) {
        int min = root.element;
        while (root.left != null) {
            min = root.left.element;
            root = root.left;
        }
        return min;
    }
}
