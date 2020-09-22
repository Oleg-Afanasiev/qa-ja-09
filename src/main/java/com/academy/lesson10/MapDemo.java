package com.academy.lesson10;

import com.academy.lesson04.Abonent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        // Map: (key, value)
        Abonent abonent1 = new Abonent();
        abonent1.setId(123);
        abonent1.setFirstName("Вася");

        Abonent abonent2 = new Abonent();
        abonent2.setId(4);
        abonent2.setFirstName("Петя");

        Abonent abonent3 = new Abonent();
        abonent3.setId(78);
        abonent3.setFirstName("Коля");

        Abonent abonent4 = new Abonent();
        abonent4.setId(33);
        abonent4.setFirstName("Игорь");

        Map<Integer, Abonent> abonentMap = new HashMap<>();
        // abonents.put(123, abonent1);
        abonentMap.put(abonent1.getId(), abonent1); // 123
        abonentMap.put(abonent2.getId(), abonent2); // 4
        abonentMap.put(abonent3.getId(), abonent3); // 78
        abonentMap.put(78, abonent4); // 78

        System.out.println(abonentMap.get(4));
        System.out.println(abonentMap.get(123));
        System.out.println(abonentMap.get(5));
        System.out.println(abonentMap.get(78));

        System.out.println(abonentMap.size());
        System.out.println(abonentMap);
        // Перебрать Map с помощью for
        // 1 шаг - достаем множество ключей
        Set<Integer> keys = abonentMap.keySet();
        Collection<Abonent> abonentsFromMap = abonentMap.values();
        for (Integer key : abonentMap.keySet()) {
            System.out.println(key);
            Abonent abonent = abonentMap.get(key);
            System.out.println(abonent.getFirstName());
        }
    }
}
