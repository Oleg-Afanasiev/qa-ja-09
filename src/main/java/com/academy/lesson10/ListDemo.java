package com.academy.lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {
        String[] names = {"Архип","Болеслав","Марат","Семён","Юлиан","Сергей","Нифонт" ,"Сергей","Максим","Евгений","Геннадий","Володар","Ждан","Марк","Григорий","Леонид","Олег"};
        for (String el : names) {
            System.out.println(el);
        }
        System.out.println("-------------");
        List<String> nameList = new ArrayList<>(Arrays.asList(names));

//        nameList.remove("Марат");
        nameList.remove(2);
        "s1".compareTo("s2");
        nameList.sort((s1,s2)-> {
            // 1 споссб
//            if (s1.equals(s2))
//                return 0;
//
//            if (s1.compareTo(s2) < 0)
//                return -1;
//
//            return 1;
//          2 споссб
            return s1.compareTo(s2);


        });
        //  3 споссб
        nameList.sort(String::compareTo);
        System.out.println(nameList);

        System.out.println("****");
        // 1 способ удалить имена на "С" - НЕ ЛУЧШИЙ
        for(int i = nameList.size() -1; i >= 0; i--) {
            if (nameList.get(i).charAt(0) != 'С') {
                nameList.remove(i);
//                System.out.println(nameList.get(i));
            }
        }

        // 2 способ удалить имена на "С"
        ListIterator<String> iterator = nameList.listIterator();
        while (iterator.hasNext()) {
            String nextName = iterator.next();
            if(nextName.charAt(0)!='С')
               iterator.remove();
        }

        System.out.println(nameList);
    }
}
