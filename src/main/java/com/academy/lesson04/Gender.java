package com.academy.lesson04;

public enum Gender {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        if (this == MALE)
            return "мужчина";
        else
            return "женщина";
    }
}
