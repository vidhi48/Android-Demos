package com.example.Demo.java_practice;
import  java.util.*;
import android.content.SyncAdapterType;

//Single Level inheritance
public class InheritanceDemo {
    int age;
}
class SubInheritance extends InheritanceDemo {
    String name;
    public static void main(String[] args) {
        SubInheritance s1 = new SubInheritance();
        System.out.println("Age: " + s1.age);
        System.out.println("Name: "+ s1.name);
    }
}

//multilevel inheritance
class A {
    void displayA() {
        System.out.println("Superclass");
    }
}
class B extends A {
    void displayB() {
        System.out.println("Subclass of A");
    }
}
class C extends  B {
    void displayC() {
        System.out.println("Subclass of B");
    }
    public static void main(String[] args) {
        A a1 = new A();
        a1.displayA();
        B b1 = new B();
        b1.displayA();
        b1.displayB();
        C c1 = new C();
        c1.displayA();
        c1.displayB();
        c1.displayC();
    }
}

//Hierarchical Inheritance
class Bike {
    String bname = "Honda";
    void displayName() {
        System.out.println("Name: "+ bname);
    }
}
class Hero extends Bike {
    int prize = 90000;
    void displayPrize() {
        System.out.println("Prize of " + bname + " is " + prize);
    }
}
class Suzuki extends Bike {
    String bcolor = "Black";
    void displayColor() {
        System.out.println("Color of " + bname + " is " + bcolor);
    }
    public static void main(String[] args) {
        Suzuki s1 = new Suzuki();
        Hero h1 = new Hero();
        h1.displayPrize();
        s1.displayName();
        s1.displayColor();
        //s1.displayPrize();
    }
}

//multiple inheritance
class ANew {
    int eno;
}
class BNew {
    String name;
}
//class CNew extends A, B {
//}

//compile-time polymorphism - method overloading
class CompileTime {
    void display(int num1) {
        System.out.println("num1: "+num1);
    }
    void display(int num1, int num2) {
        System.out.println("num1: "+ num1 + " num2: " + num2);
    }

    public static void main(String[] args) {
        CompileTime t1 = new CompileTime();
        t1.display(5);
        t1.display(5,7);
    }
}

//Operator overloading
class OperatorOverload {
    void check(int a, int b) {
        int sum = a + b;
        System.out.println("Addition: "+ sum);
    }
    void check(String a, String b) {
        String f = a + b;
        System.out.println("Concatination of string: "+ f);
    }

    public static void main(String[] args) {
        OperatorOverload o1 = new OperatorOverload();
        o1.check(2,5);
        o1.check("Simform ", "Solutions");
    }
}

//Run-time polymorphism
class RunTime {
    void find() {
        System.out.println("Superclass");
    }
}
class SubRun extends RunTime {
    @Override
    void find() {
        super.find();
        System.out.println("Subclass");
    }
}
class Test {
    public static void main(String[] args) {
        RunTime r1 = new SubRun();
        r1.find();
    }
}

//abstraction
abstract class DemoAbstract {
    abstract void display();
    void check() {
        System.out.println("Non-abstract method.");
    }
}
class SubAbstract extends DemoAbstract {
    void display() {
        System.out.println("Abstract method.");
    }
    public static void main(String[] args) {
        SubAbstract s1 = new SubAbstract();
        s1.display();
        s1.check();
    }
}

//Encapsulation
class Area {
    int length;
    int breadth;
    Area(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    public void getArea() {
        int area = length * breadth;
        System.out.println("Area: " + area);
    }
}
class Main {
    public static void main(String[] args) {
        Area rectangle = new Area(5, 6);
        rectangle.getArea();
    }
}

//ArrayList
class DemoArray {
    public static void main(String[] args) {
        ArrayList<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add(1, "Wednesday");
        System.out.println("Days: "+ days);
        String str = days.get(1);
        System.out.println(str);
        days.set(0, "Sunday");
        System.out.println(days);
        String rem = days.remove(0);
        System.out.println(rem);
    }
}

//Hash-map
class HashExamp {
    public static void main(String[] args) {
        Map<Integer, String> map = new
    }
}

//if-else
class DemoIf {
    public static void main(String[] args) {
        int num = 7;
        if (num % 2 == 0)
            System.out.println("Number is even");
        else
            System.out.println("Number is odd.");
    }
}

