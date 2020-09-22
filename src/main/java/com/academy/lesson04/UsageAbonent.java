package com.academy.lesson04;

public class UsageAbonent {
    public static void main(String[] args) {
        Abonent abonent1 = new Abonent();
        abonent1.setFirstName("Peter");
        Abonent abonent2 =  new Abonent();
        System.out.println(abonent2.getFirstName());
        abonent2.setFirstName("Lena");
        System.out.println(abonent1.getFirstName());
        System.out.println("***");

        Abonent abonent = initAbonentData();
        handleAbonent(abonent);
    }

    private static void handleAbonent(Abonent abonent) {
        System.out.println(abonent.getFirstName());
        System.out.println(abonent);
    }

    private static Abonent initAbonentData() {
        Abonent abonent = new Abonent();
        abonent.setFirstName("Ivan");
        abonent.setGender(Gender.MALE);
        return abonent;
    }
}
