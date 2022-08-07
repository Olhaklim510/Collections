package com.company;

class TestMyStack {
    public static void main(String[] args) {
        MyStack <String> myStack=new MyStack<>();

        //[Masha, Dasha, Natasha]
        myStack.push("Masha");
        myStack.push("Dasha");
        myStack.push("Natasha");
        System.out.println(myStack);

        //[Masha, Dasha]
        myStack.remove(2);
        System.out.println(myStack);

        //2
        System.out.println(myStack.size());

        //Dasha
        System.out.println(myStack.peek());

        //Dasha
        System.out.println(myStack.pop());
        System.out.println(myStack);//[Masha]

        //Clean
        System.out.println("Clean");
    }
}
