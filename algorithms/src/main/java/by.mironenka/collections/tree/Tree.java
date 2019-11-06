package by.mironenka.collections.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;
    private E e;

    public Tree(E e) {
        this.e = e;
        this.root = new Node<>(this.e);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        boolean flag = false;

        Node<E> ch = new Node(child);
        Node<E> par = this.findBy(parent).get();
        Iterator it = this.iterator();
        while(it.hasNext()) {
            Node<E> node = (Node<E>) it.next();
            if (node.getValue().equals(child)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            par.add(ch);
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                result = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    /**
     * Checks if tree is binary.
     * @return boolean
     */
    public boolean isBinary() {
        boolean result = true;
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Node<E> child = (Node<E>) it.next();
            if (child.leaves().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator it = new Iterator() {
            private Queue<Node<E>> data = new LinkedList<>();
            {
                this.data.offer(Tree.this.root);
            }
            @Override
            public boolean hasNext() {
                return !this.data.isEmpty();
            }

            @Override
            public Node<E> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> element = this.data.remove();
                for (Node<E> child : element.leaves()) {
                    this.data.offer(child);
                }
                return element;
            }
        };
        return it;
    }
}
