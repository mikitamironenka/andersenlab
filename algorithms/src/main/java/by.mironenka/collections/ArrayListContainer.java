package by.mironenka.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListContainer<E> implements Iterable {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] container;
    private int elements = 0;
    private int modCount = 0;

    public ArrayListContainer() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    public ArrayListContainer(int capacity) {
        this.container = new Object[capacity];
    }

    public int getElements() {
        return this.elements;
    }

    public E[] getContainer() {
        return (E[]) this.container;
    }

    public void add(E e) {
        if (this.elements == this.container.length) {
            increaseCapacity();
        } else {
            this.container[elements++] = e;
        }
    }

    public E get(int index) {
        return (E)this.container[index];
    }

   public E remove(int index) {
       E result = (E)this.container[index];
       System.arraycopy(this.container, index + 1, this.container, index, this.container.length - 1 - index);
       this.elements--;
       return result;
   }

    public boolean isContains(E e) {
        boolean result = false;
        for (int i = 0; i < this.container.length; i++) {
            if (this.container[i].equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }


    private void increaseCapacity() {
        Object[] newArray = new Object[this.container.length * 2];
        System.arraycopy(this.container, 0, newArray, 0, this.container.length);
        this.container = newArray;
        modCount++;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {

            private int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return ((container.length > index) && (container[index] != null));
            }

            @Override
            public Object next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[index++];
            }
        };
        return iterator;
    }
}
