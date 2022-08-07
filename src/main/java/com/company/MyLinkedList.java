package com.company;

import java.util.StringJoiner;

class MyLinkedList<E> {
    Node<E> first;
    Node<E> last;

    public static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }
    }

    public void add(Object value) {
        if (last == null) {
            first = new Node(value, null, null);
            last = first;
        } else {
            Node newNode = new Node(value, null, last);
            last.next = newNode;
            last = newNode;
        }
    }

    public void remove(int index) {
        int count = 0;
        Node n = first;
        while (true) {
            if (n == null) {
                throw new IndexOutOfBoundsException("Index " + index + ", size " + count);
            } else if (index == count) {
                if (n.prev != null) {
                    if (n.next == null) {
                        n.prev.next = null;
                        last = n.prev;
                    } else {
                        n.prev.next = n.next;
                    }
                } else {
                    first = n.next;
                }
                return;
            }
            n = n.next;
            count++;
        }
    }

    public int size() {
        int size = 0;
        Node n = first;
        while (n != null) {
            n = n.next;
            size++;
        }
        return size;
    }

    public Object get(int index) {
        int count = 0;
        Node n = first;
        while (true) {
            if (n == null) {
                throw new IndexOutOfBoundsException("Index " + index + ", size " + size());
            } else if (index == count) {
                return n.element;
            }
            n = n.next;
            count++;
        }
    }

    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public String toString() {
        StringJoiner builder = new StringJoiner(" ");
        Node n = first;
        while (n != null) {
            builder.add(n.getElement().toString());
            n = n.next;
        }
        return builder.toString();
    }
}
