package com.academy.lesson04;

import com.academy.lesson08.WrongAgeException;

public class Abonent implements Comparable<Abonent>  {
    private int id;
    private String firstName;
    private Gender gender; // 'f', 'm'
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws WrongAgeException {
        if (age > 0)
            this.age = age;
        else
            throw new WrongAgeException(age); // бросаем исключение
    }

    @Override
    public int compareTo(Abonent o) {
        return this.getFirstName().compareTo(o.getFirstName());
    }

    @Override
    public String toString() {
        return firstName + ":" + gender + ":" + age;
    }
}
