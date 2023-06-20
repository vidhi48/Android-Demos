package com.example.demo.javapractice;

public class EnumDemo {

    enum Color {

        Green, Red, Blue;
    }

    public static void main(String[] args) {

        Color c1 = Color.Green;
        System.out.println(c1);
        System.out.println(Color.Blue.ordinal());

        Color arr[] = Color.values();
        for (Color col : arr) {
            System.out.println(col + " at index " + col.ordinal());
        }
    }
}

enum Days {

    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
}

class DaysEnum {

    Days day;

    DaysEnum(Days day) {
        this.day = day;
    }

    void doSomething() {

        switch (day) {
            case Sunday:
                System.out.println("Sunday");
                break;
            case Monday:
                System.out.println("Monday");
                break;
            case Tuesday:
                System.out.println("Tuesday");
                break;
            case Wednesday:
                System.out.println("Wednesday");
                break;
            case Thursday:
                System.out.println("Thursday");
                break;
            case Friday:
                System.out.println("Friday");
                break;
            case Saturday:
                System.out.println("Saturday");
                break;
        }
    }

    public static void main(String[] args) {

        String str = "Friday";
        DaysEnum d1 = new DaysEnum(Days.valueOf(str));
        d1.doSomething();
    }
}