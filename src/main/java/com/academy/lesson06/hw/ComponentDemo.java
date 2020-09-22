package com.academy.lesson06.hw;

import java.util.Random;

public class ComponentDemo {
    public static void main(String[] args) {
        Component[] array = {
                new Button(),
                new Button()
                //new Label()
        };

        for (int i = 0; i < array.length; i++) {
            array[i].draw();
        }

        Component[] testElements = {
                new Button(),
                new Label()
        };

        Component[] arrayRandom = new Component[100];
        Random random = new Random();
        random.nextInt(4); // 0, 1, 2, 3
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = testElements[random.nextInt(testElements.length)];// случайный тип
        }

        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i].draw();
        }
    }
}
