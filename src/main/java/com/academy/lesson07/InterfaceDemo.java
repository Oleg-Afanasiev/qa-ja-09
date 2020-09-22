package com.academy.lesson07;

public class InterfaceDemo {
    public static void main(String[] args) {
        Profile person = new Person("Vasiliy");
        person.info(); // не статический метод, для вызова нужно создать экземпляр класса
        Person.about(); // статический метод, можно вызвать не создавая экземпляр класса (объект)
        // person.about();
        if (person instanceof Person)
            ((Person)person).description();

        System.out.println("***");
        Profile programmer = new Programmer("Helen");
        programmer.info(); // => I am Vasiliy. / I am a programmer

        System.out.println("***");
        Profile boxer = new Boxer("Petya");
        boxer.info();

        Profile[] persons = new Profile[5];

        persons[0] = new Person("Kolya");
        persons[1] = new Boxer("Miha");
        persons[2] = new Boxer("Vitaliy");
        persons[3] = new Programmer("Ivan");
        persons[4] = new Person("Alexey");

        // вывести всех
        System.out.println("******");
        for (int i = 0; i < persons.length; i++) {
            persons[i].info();
            if (persons[i] instanceof Boxer)
                ((Boxer) persons[i]).boxing();
        }
    }
}
