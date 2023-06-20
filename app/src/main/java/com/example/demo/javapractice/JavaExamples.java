package com.example.demo.javapractice;

public class JavaExamples {

    static int eno;
    static String name;

    static void set(int id, String n) {
        eno = id;
        name = n;
    }

    static void get() {
        System.out.println("Id: " + eno);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        JavaExamples.set(1, "vidhi");
        //JavaExamples.get();
        JavaExamples.get();
    }
}

class Demo {

    int age;
    String name;

    Demo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        Demo d1 = new Demo(20, "vidhi");
        System.out.println(d1.age + d1.name);
        //Demo d2 = d1.clone();

    }
}
