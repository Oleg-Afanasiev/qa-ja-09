package com.academy.lesson07;

public class AnonymousDemo {
    public static void main(String[] args) {
        Profile musician = new Profile() {
            @Override
            public void info() {
                System.out.println("I am musician");
            }
        };

        musician.info();

        Profile footballer = () -> System.out.println("I am footballer");
        footballer.info();

         // StringHandler handler = s -> System.out.println(s);
         StringHandler handler = System.out::println;
        handler.handle("Hello world");

        // StringFunc func = s -> s.toUpperCase();
        StringFunc func = String::toUpperCase;
        String str = func.apply("hello World");
        System.out.println(str);

        StringFunc func2 = s -> s.substring(0, 5);
        System.out.println(func2.apply("Hello worlds"));
    }
}
