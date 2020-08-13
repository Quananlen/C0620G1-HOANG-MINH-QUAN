import java.util.Arrays;
class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity) {
        elements = new Object[capacity];
    }
    //    private void ensureCapacity() {
//        if (size > elements.length) {
//            E[] newElement = ((E[]) new Object[size * 2 + 1]);
//            System.arraycopy(elements, 0, newElement, 0, newElement.length);
//            elements = newElement;
//        }
//    }
    public void ensureCapacity(int minCapacity) {
        elements = Arrays.copyOf(elements, minCapacity);
    }
    public void add(int index, E element) {
        ensureCapacity(20);
        elements[index] = element;
        size++;
    }
    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        return true;
    }
    public E remove(int index) {
        checkIndex(index);
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
    public int size() {
        return size;
    }
    public E clone() {
        E newElements = (E) new Object[size];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        return newElements;
    }
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
    public boolean add(E element) {
        if (size <= 0 || size >= elements.length) {
            return false;
        }
        return true;
    }
    public E get(int index) {
        if (checkIndex(index)) {
            return (E) elements[index];
        }
        return null;
    }
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}