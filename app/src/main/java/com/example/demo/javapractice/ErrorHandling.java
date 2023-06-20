package com.example.demo.java_practice;

public class ErrorHandling {
    public int[] arr = new int[10];
    public void writeList() {
        try {
            arr[10] = 11;
        } catch (NumberFormatException e1) {
            System.out.println("NumberFormatException => " + e1.getMessage());
        } catch (IndexOutOfBoundsException e2) {
            System.out.println("IndexOutOfBoundsException => " + e2.getMessage());
        }
    }
}
class MainOf {
    public static void main(String[] args) {
        ErrorHandling err = new ErrorHandling();
        err.writeList();
    }
}

//user-defined exception
class CustomExcep extends Exception{
    CustomExcep(String str) {
        super(str);
    }
}
class UseCustom {
    static void check(int age) throws CustomExcep {
        if (age < 18) {
            throw new CustomExcep("Age is not valid.");
        } else {
            System.out.println("Age is valid.");
        }
    }

    public static void main(String[] args) {
        try {
            check(5);
        }
        catch (CustomExcep ex) {
            System.out.println("Exception " + ex);
        }
    }
}