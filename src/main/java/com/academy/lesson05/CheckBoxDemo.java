package com.academy.lesson05;

import com.academy.lesson04.Button;

public class CheckBoxDemo {
    public static void main(String[] args) {
        CheckBox checkBox = new CheckBox();
        System.out.println(checkBox.isChecked());
        System.out.println(checkBox.getText());
        System.out.println(checkBox.getWidth());
    //    checkBox.width = -19;
//        checkBox.isChecked = true;
        Button btn = new Button();
        btn.setText("Login");
        btn.setWidth(5);
        btn.print("Custom btn");
        System.out.println("*****");
        checkBox.print();
        checkBox.print("Custom checkbox");

        System.out.println("****");
        System.out.println(btn);

        Button btn2 = new Button();
        btn2.draw();
    }
}
