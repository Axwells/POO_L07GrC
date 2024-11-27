package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Classe générique Stack
public class Stack<T> implements Iterable<T> {
    private Node<T> top; // Sommet de la pile
    private int size;    // Taille de la pile

    // Classe interne pour les nœuds de la liste chaînée
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    // Constructeur
    public Stack() {
        top = null;
        size = 0;
    }

    // Empiler un élément
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Désempiler un élément
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("La pile est vide.");
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    // Obtenir le sommet sans le retirer
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("La pile est vide.");
        return top.value;
    }

    // Vérifier si la pile est vide
    public boolean isEmpty() {
        return size == 0;
    }

    // Obtenir la taille de la pile
    public int size() {
        return size;
    }

    // Représentation sous forme de chaîne
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

    // Retourner un tableau des éléments
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

    // Obtenir un itérateur
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    // Classe interne pour l'itérateur
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
