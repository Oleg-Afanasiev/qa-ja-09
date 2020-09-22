package com.academy.lesson02;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("\"\\\\Hello World\\\\\"");
        String msg;
        char ch = 'A';
        char ch2 = 'A' + 'b';
        char ch3 = 'А';
        System.out.println(ch2);
        System.out.println((int)ch3);
        long l1 = 3000000000L;
        int i1 = (int)l1;

        int i2 = 567;
        long l2 = i2;
        System.out.println(i1);
        System.out.println(i2);

        System.out.println(10*(2.0-1.1)/10);
        int i3 = 1;
        //i3++;
//        i3 = i3 + 1;
//        i3 = i3 + 1;
         i3 = i3 + i3;
        System.out.println(i3);

        boolean isEqual = i1 == i3;
        System.out.println(isEqual);

        int n = 10;
        // Выводим строки
        for (int i = 0; i < n; i++) {
            // Выводим столбцы
            for (int k = 0; k < n; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}
