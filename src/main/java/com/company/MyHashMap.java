package com.company;

import java.util.Objects;
import java.util.StringJoiner;

class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 1 << 4;//16
    Node[] table = new Node[DEFAULT_CAPACITY];

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;


        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public final int hashCode() {
            return Objects.hashCode(key);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    public void put(Object key, Object value) {
        int backetKey;
        int h = 0;
        if (key == null) {
            for (int i = 0; i < table.length; i++) {
                if (table[i].key == null) {
                    table[i].value = value;
                }
                return;
            }
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        backetKey = h & (table.length - 1);
        Node node = table[backetKey];
        if (node == null) {
            table[backetKey] = new Node<>(h, key, value, null);
        } else {
            Node n = node;
            while (true) {
                if (n.hash == h && n.key.equals(key)) {
                    n.value = value;
                    return;
                }
                if (n.next == null) {
                    n.next = new Node<>(h, key, value, null);
                } else {
                    n = n.next;
                }
            }
        }
    }

    public void remove(Object key) {
        int backetKey;
        int h = 0;
        Node previosNode = null;
        if (key == null) {
            Node node = table[0];
            while (node != null) {
                if (node.key == null) {
                    if (previosNode != null) {
                        previosNode.next = node.next;
                    } else {
                        table[0] = node.next;
                    }
                    return;
                } else {
                    previosNode = node;
                }
                node = node.next;
            }
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        backetKey = h & (table.length - 1);
        Node node = table[backetKey];
        if (node == null) {
            return;
        } else {
            while (true) {
                if (node.hash == h && node.key.equals(key)) {
                    if (previosNode != null) {
                        previosNode.next = node.next;
                    } else {
                        table[backetKey] = node.next;
                    }
                    return;
                }
                if (node.next == null) {
                    return;
                } else {
                    previosNode = node;
                    node = node.next;
                }
            }
        }
    }

    public int size() {
        int size = 0;
        for (Node node : table) {
            Node n = node;
            while (n != null) {
                size++;
                n = n.next;
            }
        }
        return size;
    }

    public Object get(Object key) {
        Object obj = new Object();
        for (Node node : table) {
            Node n = node;
            while (n!=null) {
                if (n.key == key) {
                    obj = n.value;
                    return obj;
                }
            }
        }
        return obj;
    }

    public void clear(){
        table= new Node[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        StringJoiner builder = new StringJoiner(" ");
        for (Node node : table) {
            Node n = node;
            while (n != null) {
                builder.add("{key:" + n.key + ",value:" + n.value + "}");
                n = n.next;
            }
        }
        return builder.toString();

    }
}
