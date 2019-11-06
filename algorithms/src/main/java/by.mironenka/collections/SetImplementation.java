package by.mironenka.collections;

import java.util.Iterator;

public class SetImplementation<E> implements Iterable {

    private static final int DEFAULT_CAPACITY = 16;
    private Object[] arr;
    private int size = 0;

    public SetImplementation() {
        this.arr = new Object[DEFAULT_CAPACITY];
    }

    public SetImplementation(int capacity) {
        this.arr = new Object[capacity];
    }

    public Object[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    private void increaseCapacity() {
        Object[] newArr = new Object[this.arr.length * 2];
        System.arraycopy(this.arr, 0, newArr, 0, this.arr.length);
        this.arr = newArr;
    }

    public boolean put(E e) {
        boolean isAdded = false;
        if (this.size == this.arr.length) {
            increaseCapacity();
        }

        if (!isElementInSet(e)) {
            this.arr[size++] = e;
            isAdded = true;
        }
        return isAdded;
    }

    private boolean isElementInSet(E e) {
        boolean result = false;
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] != null && this.arr[i].equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }
    @Override
    public Iterator iterator() {
        Iterator it = new Iterator() {

            private int index = 0;
            @Override
            public boolean hasNext() {
                return ((index < arr.length) && (arr[index] != null));
            }

            @Override
            public E next() {

                while(index < arr.length) {
                    return (E) arr[index++];
                }
                return null;
            }
        };
        return it;
    }
}
