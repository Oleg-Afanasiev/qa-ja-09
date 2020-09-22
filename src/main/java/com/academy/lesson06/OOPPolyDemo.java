package com.academy.lesson06;

import com.academy.lesson05.Date;
import com.academy.lesson05.DateTime;

public class OOPPolyDemo {
    public static void main(String[] args) throws Exception {
        Date date = new Date(3, 12, 2004);
        Object date2 = new Date(3, 12, 2004);
        // String date3 = new Date(3, 12, 2004);
        // DateTime date4 = new Date(3, 12, 2004);
        Date date5 = new DateTime();
        date5.setDay(5);

        DateTime origin2 = null;

        DateTime origin = (DateTime)date5;

        if (date instanceof DateTime) {
            origin2 = (DateTime) date;
            origin2.setHour(3);
        }

//        ((DateTime)date5).setHour(5);
        origin.setHour(5);

        System.out.println(origin);

        DateTime dateTime = new DateTime();
        dateTime.setHour(20);
        dateTime.setMinute(7);
        dateTime.setSecond(34);

        dateTime.setYear(2020);
        dateTime.setMonth(8);
        dateTime.setDay(19);

        System.out.println("***");
        Date[] arr = {date, dateTime};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("*****");
        Object[] arr2 = {date, dateTime, "Hello world!"};
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
