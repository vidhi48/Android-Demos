package com.example.demo.javapractice;

interface Worker {

    int dis();
}

public class Lambdas {

    public static void main(String[] args) {
        Worker wr;
        wr = () -> 10;
        System.out.println(wr.dis());
    }
}

interface Student {

    int op(int a, int b);
}

class NewStudent {
    public static void main(String[] args) {
        Student s1 = (a, b) -> a + b;
        System.out.println("Sum: " + s1.op(5,5));
    }
}
