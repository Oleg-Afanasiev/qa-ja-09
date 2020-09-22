package com.academy.lesson05;

public class DateTimeDemo {
    public static void main(String[] args) throws Exception {
        Date date = new Date(18, 8, 2020);
        System.out.println(date); // => 18.08.2020
        assert date.toString().equals("18.08.2020");

        DateTime dateTime = new DateTime();
        dateTime.setHour(20);
        dateTime.setMinute(7);
        dateTime.setSecond(34);

        dateTime.setYear(2020);
        dateTime.setMonth(8);
        dateTime.setDay(19);
        System.out.println(dateTime); // => 18.08.2020 20:47:53

        Date[] dates = new Date[3];
        dates[0] = new Date(23, 2, 1990);
        dates[1] = new Date(7, 8, 2000);
        dates[2] = new Date(16, 9, 2020);

        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }
    }
}
