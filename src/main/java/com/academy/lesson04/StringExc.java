package com.academy.lesson04;

public class StringExc {
    public static void main(String[] args) {
        String str = "oHello worlod!! hello"; // lo
//        int index = str.indexOf("lo", 18);
//        System.out.println(index);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'o')
                count++;
        }
        assert count == 5;
        System.out.println(count);

        int index = str.indexOf("lo");
        int count2 = 0;
        while (index != -1) {
            count2++;
            index = str.indexOf("lo", index + 1);
        }
        assert count2 == 3;
        System.out.println(count2);


    }
}
