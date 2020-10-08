package com.academy.lesson15;

public class Demo {
    public static void main(String[] args) {
        String template = "Count of products %d !";
        int n = 7;

        String resultString = String.format(template, n);
        System.out.println(resultString);


    }
}
