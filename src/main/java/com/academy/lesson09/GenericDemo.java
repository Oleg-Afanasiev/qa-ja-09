package com.academy.lesson09;

import com.academy.lesson04.Abonent;

import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        List<String> list;
        List<Integer> list2;
        List<Abonent> list3;

        Object universal = "Hello";
        universal = 1;
        universal = new Abonent();
        universal = "Ivan";
//        universal = 2;
        if (universal instanceof String) {
            universal = ((String) universal).toUpperCase();
        }

        System.out.println(universal);

        Integer number = 4;
        Object objNumber = (Object)number;
//        String strNumber = (String)number;

        System.out.println("*******");
        Pair<String, Integer> pair =getPair();
        String value1 = pair.getVal1();
        Integer value2 =  pair.getVal2();
        System.out.println(value1);
        System.out.println(value2);

        Pair<Integer, Integer> pair2 = new Pair<>();
        pair2.setVal1(23);
        pair2.setVal2(27);

        pair = getPair();
        Pair<Integer, Abonent> pair3;
        Pair<Integer, Pair<Integer, String>> pair4;

        dynamicArgs(1);
        dynamicArgs(1, 2, 3);
    }

    public static Pair<String, Integer> getPair() {
        Pair<String, Integer> pair = new Pair<>();
        pair.setVal1("Ivan");
        pair.setVal2(1);
        return pair;
    }

    public static void dynamicArgs(Integer... args) {
        
    }
}
