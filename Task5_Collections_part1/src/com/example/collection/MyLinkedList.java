package com.example.collection;

import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {
    private class Node {
        Node prevNode;
        E element;
        Node nextNode;

        Node(Node prevNode, E element, Node nextNode) {
            this.prevNode = prevNode;
            this.element = element;
            this.nextNode = nextNode;
        }
    }

    private class Iter implements Iterator<E> {
        Node next = first;

        Iter() {}

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            E element = next.element;
            next = next.nextNode;
            return element;
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;
    private E type = null;

    public MyLinkedList() {}

    @Override
    public void add(E element) {
        Node l = last;
        Node newNode = new Node(last, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.nextNode = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        throwIfCantInsert(index);
        if (index == size) {
            add(element);
        } else {
            linkBefore(element, getNode(index));
            size++;
        }
    }

    @Override
    public void clear() {
        for (Node n = first; n != null;) {
            Node next = n.nextNode;
            n.nextNode = null;
            n.prevNode = null;
            n.element = null;
            n = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public int indexOf(E element) {
        if (size == 0) {
            return -1;
        }
        Node node = first;
        int index = 0;
        if (element == null) {
            while (node != null) {
                if (node.element == null) {
                    return index;
                }
                node = node.nextNode;
                index++;
            }
        } else {
            while (node != null) {
                if (element.equals(node.element)) {
                    return index;
                }
                node = node.nextNode;
                index++;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        throwIfNotExist(index);
        Node node = getNode(index);
        Node prev = node.prevNode;
        Node next = node.nextNode;
        if (prev == null) {
            first = next;
        } else {
            prev.nextNode = next;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prevNode = prev;
        }
        node.prevNode = null;
        node.nextNode = null;
        size--;
        return node.element;
    }

    @Override
    public E set(int index, E element) {
        throwIfNotExist(index);
        getNode(index).element = element;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node n = first; n != null; n = n.nextNode) {
            array[i++] = n.element;
        }
        return array;
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length < size)
            array = (E[])java.lang.reflect.Array.newInstance(
                    array.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = array;
        for (Node node = first; node != null; node = node.nextNode)
            result[i++] = node.element;

        if (array.length > size)
            array[size] = null;

        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    // Helper functions
    private void throwIfNotExist(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void throwIfCantInsert(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void linkBefore(E element, Node node) {
        Node prev = node.prevNode;
        Node newNode = new Node(prev, element, node);

        node.prevNode = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.nextNode = newNode;
        }
    }

    private Node getNode(int index) {
        throwIfNotExist(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }
        return node;
    }
}
