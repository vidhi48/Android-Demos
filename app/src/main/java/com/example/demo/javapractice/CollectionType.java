package com.example.demo.java_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//ArrayList
class DemoArray {
    public static void main(String[] args) {

        //ArrayList
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

        System.out.println("Iterating over List ");
        for(int i = 0; i<days.size(); i++) {
            System.out.println(days.get(i) + " ");
        }

        //LinkedList
        List<String> l1 = new LinkedList<>();
        l1.add("January");
        l1.add("February");
        l1.add("March");
        System.out.println("Months: "+ l1);

    }
}


class HashExamp {
    public static void main(String[] args) {

        //Hash-map
        Map<Integer, String> m1 = new HashMap<>();
        m1.put(1,"Sunday");
        m1.put(2,"Monday");
        System.out.println(m1);
        System.out.println(m1.keySet());
        System.out.println(m1.values());

        for (Map.Entry<Integer, String> e : m1.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());

        //LinkedHashMap
        Map<String, Integer> m2 = new LinkedHashMap<>();
        m2.put("Green", 20);
        m2.put("Black", 10);
        System.out.println(m2);

        //TreeMap
        Map<String, Integer> m3 = new TreeMap<>();
        m3.put("Dog", 2);
        m3.put("Cat", 3);
        System.out.println(m3);
    }
}
