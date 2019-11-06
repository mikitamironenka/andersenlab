package by.mironenka.collections;

import java.util.Iterator;
import java.util.Objects;

public class MapImplementation<K, V> implements Iterable<V> {

    private Entry<K, V>[] buckets;
    private static final int DEFAULT_CAPACITY = 16;
    private int size = 0;

    public MapImplementation() {
        this.buckets = new Entry[DEFAULT_CAPACITY];
    }

    public MapImplementation(int capacity) {
        this.buckets = new Entry[capacity];
    }

    public int getSize() {
        return this.size;
    }

    /**
     * Checks is key null. If key is null throws IllegalArgumentException.
     * @param key key
     */
    private void isKeyIsNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cant be null");
        }
    }

    /**
     * Calculates index for entry.
     * @param key key
     * @return int value - index buckets where to hold entry.
     */
    private int indexForKey(K key) {
        return key.hashCode() % buckets.length;
    }

    /**
     * Insert pair to map.
     * @param key
     * @param value
     * @return boolean true if insert is done.
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        isKeyIsNull(key);
        int index = indexForKey(key);
        Entry<K, V> entry = buckets[index];

        if (entry != null) {
            boolean done = false;
            while (!done) {
                if (key.equals(entry.getKey())) {
                    entry.setValue(value);
                    done = true;
                    result = true;
                } else if (entry.getNext() == null) {
                    entry.setNext(new Entry<>(key, value));
                    done = true;
                    result = true;
                    size++;
                }
                entry.getNext();
            }
        } else {
            buckets[index] = new Entry<>(key, value);
            result = true;
            size++;
        }
        return result;
    }

    /**
     * Gets value by key.
     * @param key
     * @return value.
     */
    public V get(K key) {
        isKeyIsNull(key);
        Entry<K, V> entry = buckets[indexForKey(key)];
        while(entry != null && !key.equals(entry.getKey())) {
            entry.getNext();
        }
        return entry.getValue();
    }


    public boolean delete(K key) {
        boolean result = false;
        isKeyIsNull(key);
        int index = indexForKey(key);
        if (! (buckets[index] == null)) {

            Entry<K, V> previous = null;
            Entry<K, V> current = buckets[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        buckets[index] = buckets[index].next;
                        result = true;
                        size--;
                    } else {
                        previous.next = current.next;
                        result = true;
                        size--;
                    }
                }
                previous = current;
                current = current.next;
            }
//            result = false;
        }
        return result;
    }


    @Override
    public Iterator<V> iterator() {
        Iterator it = new Iterator() {

            Entry<K, V> entry = null;
            Entry<K, V>[] table = buckets;
            int index = 0;

            /**
             * Returns true if map has next element
             * @return boolean
             */
            @Override
            public boolean hasNext() {

                boolean result = false;

                if(entry != null) {
                    result = entry.getNext() != null;
                }
                if (entry == null || !result) {
                    while(index < table.length) {
                        if(table[index] != null){
                            result = true;
                            break;
                        }
                        index++;
                    }
                }
                return result;
            }

            /**
             * Returns Value of next element
             * @return V value
             */
            @Override
            public V next() {

                Entry<K, V> result = entry;

                if(entry != null) {
                    result = entry.getNext();
                } else {
                    while(index < table.length) {
                        if(table[index] != null) {
                            result = table[index++];
                            break;
                        }
                        index++;
                    }
                }

                return result.getValue();

            }

        };
        return it;
    }

    /**
     * Class creates nodes with pairs key-value
     * @param <K> key
     * @param <V>value
     */
    private class Entry<K, V> {
        /**
         * Link to the next entry(node).
         */
        private Entry<K, V> next;
        private final K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) &&
                    Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
