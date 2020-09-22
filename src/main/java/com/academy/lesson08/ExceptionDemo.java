package com.academy.lesson08;

import com.academy.lesson04.Abonent;
import com.academy.lesson05.Date;

public class ExceptionDemo {
    public static void main(String[] args) {
        Abonent abonent = new Abonent();
        abonent.setFirstName("Вася");

        try {
            abonent.setAge(10);
            abonent.setFirstName("Вася");
            System.out.println("-------");
        } catch (WrongAgeException e) {
            System.out.println("Wrong age: " + e.getWrongAge());
        } catch (Exception e) {
            System.out.println("Unknown error. Details: " + e.getMessage());
        } finally {
            System.out.println("Complete");
        }

        System.out.println("****");
        System.out.println(abonent);

        try {
            Date date = new Date(1, 23, 2020); // должно быть выброшено исключение
            System.out.println(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
