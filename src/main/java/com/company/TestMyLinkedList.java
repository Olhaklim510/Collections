package com.company;

class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList <String> myLinkedList=new MyLinkedList<>();

        //Hello World !
        myLinkedList.add("Hello");
        myLinkedList.add("World");
        myLinkedList.add("!");
        System.out.println(myLinkedList);

        //Hello World
        myLinkedList.remove(2);
        System.out.println(myLinkedList);

        //2
        System.out.println(myLinkedList.size());

        //Hello
        System.out.println(myLinkedList.get(0));

        //Clean
        myLinkedList.clear();
        System.out.println("Clean"+myLinkedList);
    }
}
