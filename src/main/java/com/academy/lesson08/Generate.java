package com.academy.lesson08;

import com.academy.lesson04.Abonent;
import com.academy.lesson04.Gender;

import java.util.Arrays;
import java.util.Random;

public class Generate {
    public static void main(String[] args) {
        //Архип,Болеслав,Марат,Семён,Юлиан,Сергей,Нифонт,Максим,Евгений,Геннадий,Володар,Ждан,Марк,Григорий,Леонид,Олег
        String[] names = {"Архип","Болеслав","Марат","Семён","Юлиан","Сергей","Нифонт","Максим","Евгений","Геннадий","Володар","Ждан","Марк","Григорий","Леонид","Олег"};
        // Массив имен
        Random random = new Random();
        Abonent[] abonents = new Abonent[10]; // 10

         // for by abonents
        for (int i = 0; i < abonents.length; i++) {
            Abonent abonent = new Abonent(); // поместить в массив
            int nextNameIndex = random.nextInt(names.length);
            String nextName = names[nextNameIndex]; // "Вася";
            abonent.setFirstName(nextName);
            abonent.setGender(Gender.MALE);
            abonents[i] = abonent;
        }

         // вывод на консоль
        System.out.println(Arrays.toString(abonents));
    }
}
