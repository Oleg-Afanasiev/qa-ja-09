package com.academy.lesson11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class FileReaderDemo {
    public static void main(String[] args) {
        // 1 способ - Хард Код
//        String path = "d:/tmp/demo/file.txt";
        // 2 способ - Через аргументы запуска
//        String path = args[0]; // Через аргументы запуска
        // 3 способ - Через файл с пропертями
        Properties properties = new Properties();
        // Связь переменной is c файлом с пропертями
        try(InputStream is = FileReaderDemo.class.getClassLoader().getResourceAsStream("demo.properties")) {
            properties.load(is); // загружаем пропертя из файла "demo.properties"
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = properties.getProperty("path.in"); // читаем проперти по ключу
        try(Scanner scanner = new Scanner(new FileInputStream(path))) {
            while(scanner.hasNext()) {
                String row = scanner.nextLine();
                System.out.println(row);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error. File not found: " + path);
//            e.printStackTrace();
        }
    }
}
