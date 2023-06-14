package com.example.demo.javapractice;

public class ControlFlow {
    public static void main(String[] args) {

        int num = 7;
        if (num % 2 == 0)
            System.out.println("Number is even");
        else
            System.out.println("Number is odd.");

        String str = "Tuesday";
        switch (str) {
            case "Monday":
                System.out.println("Monday");
                break;
            case "Tuesday":
                System.out.println("Tuesday");
            case "Wednesday":
                System.out.println("Wednesday");
                break;
            case "Thursday":
                System.out.println("Thursday");
                break;
            default:
                System.out.println("default case");
        }
        System.out.println("while Loop:");
        int count = 1;
        while (count < 5) {
            System.out.println(count);
            count++;
        }

        System.out.println("do-while Loop:");
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);

        System.out.println("for Loop:");
        for (int j = 0; j <= 5; j++) {
            System.out.println(j);
        }

        System.out.println("forEach Loop:");
        int num2[] = {5, 7, 9};
        for (int valOf: num2) {
            System.out.println(valOf);
        }

    }
}