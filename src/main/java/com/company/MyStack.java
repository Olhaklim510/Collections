package com.company;

import java.util.StringJoiner;

class MyStack<E> {

    private static final int DEFAULT_CAPACITY = 1;
    Object[] array = new Object[DEFAULT_CAPACITY];
    int position = 0;

    public void push(Object value) {
        array[position++] = value;
        if (position == array.length) {
            Object[] arrayCopy = new Object[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                arrayCopy[i] = array[i];
            }
            array = arrayCopy;
        }
    }

    public void remove(int index) {
        if (index >= position) {
            throw new IndexOutOfBoundsException("Index " + index + ", size " + array.length);
        }
        position--;
        while (index < position) {
            array[index] = array[index + 1];
            index++;
        }
    }

    public int size() {
        return position;
    }

    public Object peek() {
        if (array.length == 0) {
            throw new NullPointerException("Empty stack");
        }
        Object object = new Object();
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] != null) {
                object = array[i];
            }
        }
        return object;
    }

    public Object pop() {
        if (array.length == 0) {
            throw new NullPointerException("Empty stack");
        }
        Object object = new Object();
        int indexPop=0;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] != null) {
                object = array[i];
                indexPop=i;
            }
        }
        remove(indexPop);
        return object=peek();
    }

    public void clear(){
        position=0;
    }

    @Override
    public String toString() {
        StringJoiner builder = new StringJoiner(", ");
        for (int i = 0; i < position; i++)
            builder.add(array[i].toString());
        return "[" + builder.toString() + "]";
    }
}
