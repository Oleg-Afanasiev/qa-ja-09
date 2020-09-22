package com.academy.lesson05;


import com.academy.lesson04.Button;

public class CheckBox extends Button {
    private boolean isChecked;
    private String text;

    public CheckBox() {
        super(5, "button parent");
        isChecked = true;
        this.text = "check box";
        // System.out.println("Checkbox Constructor");
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void print() {
        System.out.println("CheckBox");
    }
}
