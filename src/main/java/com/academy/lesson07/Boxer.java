package com.academy.lesson07;

public class Boxer extends Person {
    public Boxer (String name){
        super(name);
    }

    @Override
    public void info() {
        super.info();
        System.out.println(("I am a boxer"));
    }

    public  void boxing (){
        System.out.println(("I make a trouble"));
    }
}
