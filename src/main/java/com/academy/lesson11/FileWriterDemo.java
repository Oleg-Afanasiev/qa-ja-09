package com.academy.lesson11;

import java.io.*;

public class FileWriterDemo {
    public static void main(String[] args) {
        String path = "d:/tmp/demo/file-out.txt";
        try(PrintWriter writer  = new PrintWriter(new FileWriter(path))) {
//            writer = new PrintWriter(new FileWriter(path));
            writer.println("Hello world");
            writer.println("row2");
            writer.println("row3");
            writer.println("row4");
            writer.flush(); // Нужно вызват в конце, для того, чтобы из буфера записать накопленную порцию данных в файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
