package com.company;

class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap <Integer, String> myHashMap=new MyHashMap<>();

        //{key:1,value:apple} {key:2,value:banana} {key:3,value:strawberry}
        myHashMap.put(1,"apple");
        myHashMap.put(2,"banana");
        myHashMap.put(3,"strawberry");
        System.out.println(myHashMap);

        //{key:1,value:apple} {key:3,value:strawberry}
        myHashMap.remove(2);
        System.out.println(myHashMap);

        //2
        System.out.println(myHashMap.size());

        //apple
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(4));//null

        //
        myHashMap.clear();
        System.out.println("Clean"+myHashMap);
    }
}
