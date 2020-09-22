package com.academy.lesson04;

import com.academy.lesson05.Component;

public class Button extends Component {
    protected int width;
    protected String text;

    public Button() {
    }

    public Button(int width, String text) {
        this.width = width;
        this.text = text;
    }

    public void incWidth() {
        width++;
    }

    public int getWidth() {
        return width;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setWidth(int width) {
        if (width > 0)
            this.width = width;
        else
            System.out.println("Wrong width");
    }

    public void print() {
        System.out.println("Button: " + width + ", " + text);
    }

    public void print(String prefix) {
        System.out.println(prefix + " " + width + ", " + text);

    }

    public String toString() {
        return "My button";
    }

    public void draw() {
        System.out.println("Draw button");
    }
}
