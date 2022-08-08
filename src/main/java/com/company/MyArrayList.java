package com.company;

import java.util.StringJoiner;

class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    Object[] array = new Object[DEFAULT_CAPACITY];
    int position = 0;

    public void add(Object value) {
        array[position++] = value;
        if(position == array.length){
            Object[] arrayCopy = new Object[(array.length*3)/2+1];
            for (int i=0;i<array.length;i++){
                arrayCopy[i]=array[i];
            }
            array=arrayCopy;
        }
    }

    public void remove(int index){
        if(index>=position){
            throw new IndexOutOfBoundsException("Index "+ index+", size "+array.length);
        }
        position--;
        while(index<position){
            array[index]=array[index+1];
            index++;
        }
    }

    public int size(){
        return position;
    }

    public Object get(int index){
        if(index>array.length){
            throw new IndexOutOfBoundsException("Index "+ index+", size "+array.length);
        }
        for(int i=0;i<array.length;i++){
            if(i==index){
                return array[i];
            }
        }
        return "";
    }

    public void clear(){
        position=0;
    }

    @Override
    public String toString() {
        StringJoiner builder = new StringJoiner(", ");
        for (int i=0;i<position;i++)
            builder.add(array[i].toString());
        return "[" + builder.toString() + "]";
    }
}