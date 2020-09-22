package com.academy.lesson10;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        String[] names = {"Архип","Болеслав","Марат","Семён","Юлиан","Сергей","Нифонт" ,"Сергей","Максим","Евгений","Геннадий","Володар","Ждан","Марк","Григорий","Леонид","Олег"};
        List<String> nameList = new ArrayList<>(Arrays.asList(names));
        Collections.sort(nameList);
        Set<String> nameSet = new TreeSet<>(nameList);
//        nameSet.add("Архип");
//        nameSet.add("Болеслав");
//        nameSet.add("Болеслав");
        System.out.println(nameSet);
        System.out.println(nameList.size());
        System.out.println(nameSet.size());

        List<String> uniqNames = new ArrayList<>(nameSet);
        System.out.println(uniqNames);
    }
}
