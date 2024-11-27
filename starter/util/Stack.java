package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack générique
 * @param <T> type stocké par la Stack
 */
public class Stack<T> implements Iterable<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("La pile est vide.");
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            sb.append(current.value).append(current.next != null ? ", " : "");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = top;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node<T> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
