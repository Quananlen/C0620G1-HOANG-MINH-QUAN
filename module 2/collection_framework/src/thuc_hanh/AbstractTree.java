package thuc_hanh;

public class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean insert(E e) {
        return false;
    }

    @Override /** Inorder traversal from the root*/
    public void inorder() {
    }

    @Override
    public int getSize() {
        return 0;
    }
}
