package thuc_hanh;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    //bai_tap
    protected void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        inorder(root.right);
        System.out.println(root.element + " ");
    }

    protected void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.println(root.element + " ");
        inorder(root.left);
        inorder(root.right);
    }

    protected boolean delete(E element) {
        if (!search(element)) return false;
        size--;
        TreeNode<E> current = root;
        TreeNode<E> parent = root;
        while (current != null) {
            if (current.element.equals(element)) {
                break;
            }
            if (((String) current.element).charAt(0) > ((String) element).charAt(0)) {
                parent = current;
                current = current.left;
            }
            if (((String) current.element).charAt(0) < ((String) element).charAt(0)) {
                parent = current;
                current = current.right;
            }
        }
        //no child
        if (current.left == null && current.right == null) {
            if (parent.left == current) parent.left = null;
            else parent.right = null;
            return true;
        }
        //one child
        if (current.left == null) {
            parent.left = current.right;
            current.right = null;
            return true;
        }
        if (current.right == null) {
            parent.right = current.left;
            current.left = null;
            return true;
        }
        //two child
        TreeNode<E> rightmost = current.left;
        TreeNode<E> rightmostParent = parent;
        while (rightmost.right != null) {
            rightmostParent = rightmost;
            rightmost = rightmost.right;
        }
        current.element = (E) rightmost.element;
        rightmostParent.right = rightmost.left;
        return true;
    }


    protected boolean search(E element) {
        TreeNode<E> current = root;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            } else if (((String) current.element).charAt(0) > ((String) element).charAt(0)) {
                if (current.left == null) return false;
                current = current.left;
            } else if (((String) current.element).charAt(0) < ((String) element).charAt(0)) {
                if (current.right == null) return false;
                current = current.right;
            }
        }
        return false;
    }
}

