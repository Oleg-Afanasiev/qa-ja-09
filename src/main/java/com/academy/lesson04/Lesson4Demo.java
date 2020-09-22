package com.academy.lesson04;

public class Lesson4Demo {
    public static void main(String[] args) {
        Button btn = new Button();
        System.out.println(btn);

        btn.setWidth(56);
        btn.incWidth();
        btn.setText("Login");
        btn.setWidth(5);

        // btn = new Button();
        System.out.println(btn.getText());
        System.out.println(btn.getWidth());
    }
}
