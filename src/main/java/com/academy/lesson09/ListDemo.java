package com.academy.lesson09;

import com.academy.lesson04.Abonent;
import com.academy.lesson08.WrongAgeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.academy.lesson04.Gender.FEMALE;
import static com.academy.lesson04.Gender.MALE;

public class ListDemo {
    public static void main(String[] args) throws WrongAgeException {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(567);
        list.add(5);
        list.add(98);
        list.add(-1);
//        list.add("Ivan");
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list);
//        Collections.sort(list);
        Comparator<Integer> sortRule = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2)
                    return 0;

                if (o1 < o2)
                    return 1;

                return -1;
            }
        };

        Comparator<Integer> sortRuleLambda = (o1, o2) -> {
            if (o1 == o2)
                return 0;

            if (o1 < o2)
                return 1;

            return -1;
        };

        list.sort(Comparator.reverseOrder());
        System.out.println(list);
//        list.sort();

        List<String> listStr = new ArrayList<>();
        listStr.add("Hello");
        listStr.add("Zet");
        listStr.add("Ivan");
        listStr.add("Peter");
        listStr.add("Василий");

        Collections.sort(listStr);
        System.out.println(listStr);

        Abonent abonent1 = new Abonent();
        abonent1.setFirstName("Ivan");
        abonent1.setAge(23);
        abonent1.setGender(MALE);

        Abonent abonent2 = new Abonent();
        abonent2.setFirstName("Kolya");
        abonent2.setAge(65);
        abonent2.setGender(MALE);

        Abonent abonent3 = new Abonent();
        abonent3.setFirstName("Helen");
        abonent3.setAge(18);
        abonent3.setGender(FEMALE);

        List<Abonent> abonents = new ArrayList<>();
        abonents.add(abonent1);
        abonents.add(abonent2);
        abonents.add(abonent3);

        // Сортировка по возрасту
        abonents.sort((a1, a2) -> {

            if (a1.getAge() == a2.getAge())
                return 0;

            if (a1.getAge() < a2.getAge())
                return -1;

            return 1;
        } );

        // Сортировка по возрасту - используем вспомогательный метод 'comparingInt' и ссылку на метод getAge
        abonents.sort(Comparator.comparingInt(Abonent::getAge));
        // Сортировка по имени
        abonents.sort(Comparator.comparing(Abonent::getFirstName));

        // Сортировка абонентов по умолчанию
        Collections.sort(abonents);
        System.out.println(abonents);
    }
}
