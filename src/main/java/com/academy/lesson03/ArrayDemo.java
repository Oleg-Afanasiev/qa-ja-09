package com.academy.lesson03;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] array = {1, -15, 10, 25, -5, 80, 3};
        int[] array2 = {1, 8};
        // 1 вывести на консоль
        printArray(array);
        System.out.println("****");

        // 2 найти мин и максимум
        System.out.println("Min: " + minimum(array));
        System.out.println("Min2: " + minimum(array2));

        //max
        int max = array[0];
        for (int i = 1; i<array.length; i++){
            if (array[i] > max)
                max = array[i];
        }
        System.out.println("Max " + max);

        // Вложенные массивы
        int[][] array2D = {
                {5, 8, 3},
                {6, -17, 11},
                {1, 100, 25, 36, 50},
                {0, 7}
        };

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.deepToString(array2D));

        System.out.println("********");
        int min2d = array2D[0][0];
        int max2d = array2D[0][0];
        for (int i = 0; i < array2D.length; i++) {
            for (int k = 0; k < array2D[i].length; k++) {
                System.out.println(array2D[i][k]); // Вывод текущего элемента
                if (array2D[i][k] < min2d) {
                    min2d = array2D[i][k];
                } // if
                if(array2D[i][k]>max2d){
                    max2d = array2D[i][k];
                }

            } // for (k)
            // System.out.println(Arrays.toString(array2D[i]));
        } // for (i)

        System.out.println("min2d: " + min2d);
        System.out.println("max2d: " + max2d);

        int number = 4;
        Integer number2 = 24;
        String str = Integer.toString(number);
        String str2 = number2.toString();
        System.out.println(str);
        System.out.println(str2);

        Character ch1 = 'A';
        char ch2 = '5';

        System.out.println(Character.isDigit(ch1));
        System.out.println(Character.isDigit(ch2));

        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        array = reverse(array);
        System.out.println(Arrays.toString(array));
    } // main

    public static void printArray(int[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int minimum(int[] array) {
        int min = array[0];
        for(int i=1; i<array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        } // for

        return min;
    }

    public static int[] reverse(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        return array;
    }
} // class
