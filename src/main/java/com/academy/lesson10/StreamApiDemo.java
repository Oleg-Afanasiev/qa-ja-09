package com.academy.lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamApiDemo {
    public static void main(String[] args) {
        String[] names = {"Архип","Болеслав","Марат","Семён","Юлиан","Сергей","Нифонт" ,"Сергей","Максим","Евгений","Геннадий","Володар","Ждан","Марк","Григорий","Леонид","Олег"};
        List<String> nameList = new ArrayList<>(Arrays.asList(names));
        System.out.println(nameList);
        nameList.stream()
                .filter(s-> s.charAt(0) == 'С')
                .forEach(System.out::println);

        // Исключаем дубликаты
        System.out.println("***");
        nameList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        String[] numbers = {"1", "3", "Вася", "4"};

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (isNumber(numbers[i])) {
                sum += Integer.parseInt(numbers[i]);
            }
        }
        System.out.println(sum);
        System.out.println("***stream***");
        sum = Arrays.stream(numbers)
                .filter(StreamApiDemo::isNumber)
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println(sum);
    }

    private static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }

        return true;
    }
}
