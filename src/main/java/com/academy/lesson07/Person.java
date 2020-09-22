package com.academy.lesson07;

public class Person implements Profile {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void info() {
        System.out.println("I am " + name);
    }

    public void description() {
        System.out.println("something about person");
    }

    public static void about() {
        System.out.println("static method: I am a person");
    }
}
