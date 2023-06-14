package com.example.Demo.java_practice;

interface DemoInterface {
    void displayName();
}

interface Printable {
    void print();
}

interface Showable {
    void show();
}

public class InterfaceAbstract implements DemoInterface {
    public static void main(String[] args) {
        InterfaceAbstract ib = new InterfaceAbstract();
        ib.displayName();
    }

    public void displayName() {
        System.out.println("Helllooo");
    }
}

class A7 implements Printable, Showable {
    public static void main(String[] args) {
        A7 obj = new A7();
        obj.print();
        obj.show();
    }

    public void print() {
        System.out.println("Hello");
    }

    public void show() {
        System.out.println("Welcome");
    }
}

