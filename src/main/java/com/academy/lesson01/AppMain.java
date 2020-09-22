package com.academy.lesson01;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Input your name: ");
        // Настраиваем ввод с коносли
        Scanner scanner = new Scanner(System.in); //
        // Вводим имя и сохраняем в строковую переменную
        String name = scanner.nextLine();

        // Возраст
        System.out.println("Input your age:");
        int age = scanner.nextInt();
        System.out.println("-------User--------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        System.out.println("********");
        // 1 способ
        System.out.print("Hello ");
        System.out.println(name);
        // 2 способ
        System.out.println("Hello " + name);
        // 3 способ
        System.out.println(String.format("Hello %s!", name));

        System.out.println("-------User--------");
        System.out.println(String.format("%5s: %s", "Name", name));
        System.out.println(String.format("%5s: %d", "Age", age));
    }
}
