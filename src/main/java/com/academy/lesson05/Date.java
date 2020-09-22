package com.academy.lesson05;

public class Date {
    protected int day;
    protected int month;
    protected int year;

    public Date() {
    }

    public Date(int day, int month, int year) throws Exception {
        if (month > 12)
            throw new Exception("Wrong month " + month);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void print(DateFormat format) {
        // логика
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%d", day, month, year);
    }
}
