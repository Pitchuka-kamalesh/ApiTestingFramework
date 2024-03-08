package com.inheritancee;

public class Hello implements First {

    @Override
    public void data() {
        System.out.println("data");
    }

    public static void main(String[] args) {

        int a = 5;
        int b =10;
        int c = 5;
        int d = 6;
        String name = "Hello";

        System.out.println(name+a+b+c+d);


        System.out.println(Third.nam);

    }
}
