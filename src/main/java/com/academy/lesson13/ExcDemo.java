package com.academy.lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ExcDemo {
    public static void main(String[] args) {
        List<String> names1 = new ArrayList<>(Arrays.asList("name1", "name2", "name3"));
        List<String> names2 = new ArrayList<>(Arrays.asList("name2", "name3", "name1"));

        System.out.println(names1.equals(names2)); // x
        // 1 способ - отсортировать и сравнить
        names1.sort(String::compareTo);
        names2.sort(String::compareTo);
        System.out.println(names1.equals(names2)); // ok

        // 2 способ (без дубликатов)
        System.out.println(names1.containsAll(names2) && names2.containsAll(names1));

        // 3 способ (без дубликатов)
        System.out.println(new HashSet<>(names1).equals(new HashSet<>(names2)));

//        String str = 1;
        ClassA var1 = null;
        ClassB var2 = null;

        var1 = var2;
    }
}
