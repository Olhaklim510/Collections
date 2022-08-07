package com.company;

class TestMyQueue {

    public static void main(String[] args) {
        MyQueue <String> myQueue=new MyQueue<>();

        //[Alex, Vlad, Pavlo]
        myQueue.add("Alex");
        myQueue.add("Vlad");
        myQueue.add("Pavlo");
        System.out.println(myQueue);

        //[Alex, Vlad]
        myQueue.remove(2);
        System.out.println(myQueue);

        //2
        System.out.println(myQueue.size());

        //Alex
        System.out.println(myQueue.peek());

        //Alex
        System.out.println(myQueue.poll());
        System.out.println(myQueue);//[Vlad]

        //Clean[]
        myQueue.clear();
        System.out.println("Clean"+myQueue);
    }
}
