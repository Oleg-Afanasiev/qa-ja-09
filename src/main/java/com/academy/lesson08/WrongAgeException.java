package com.academy.lesson08;

public class WrongAgeException extends Exception {
    private int wrongAge;

    public WrongAgeException(int wrongAge) {
        this.wrongAge = wrongAge;
    }

    public int getWrongAge() {
        return wrongAge;
    }
}
