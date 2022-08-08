package com.company;

public class TestMyArrayList {

    public static void main(String[] args) {
        MyArrayList <Integer> myArrayList=new MyArrayList <>();

        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        myArrayList.add(10);
        myArrayList.add(11);
        System.out.println(myArrayList);

        //[0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11]
        myArrayList.remove(5);
        System.out.println(myArrayList);

        //11
        System.out.println(myArrayList.size());

        //3
        System.out.println(myArrayList.get(3));

        //Clean[]
        myArrayList.clear();
        System.out.println("Clean"+myArrayList);
    }
}
