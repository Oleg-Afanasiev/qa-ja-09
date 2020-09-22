package com.academy.lesson03;

import java.util.Random;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "A1";
        String str2 = "A" + 1;
        String str3 = new String("A1");

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        System.out.println(str1.equals(str3));

        System.out.println("******");
        int n1 = 500;
        int n2 = 500;
        System.out.println(n1 == n2);
        Integer m1 = 500;
        Integer m2 = 500;
        System.out.println(m1.equals(m2));

        // Случайное число
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println(randomNumber);

        System.out.println("*****");
        String[] tracks = {
                "track_01", "track_03", "track_21", "track_15",
                "track_12", "track_99", "track_11", "track_10"
        };

        filterTrack(tracks);

        String str = "Ivan_Ivanov";
        String firstName = str.substring(0); // <-Ivan
        String lastName  = str.substring(0); // <-Ivanov
        System.out.println(firstName);
        System.out.println(lastName);

        String name = "ivAn"; // Ivan
        String capitalized = name.toUpperCase();
        String capitalized2 = name.toLowerCase();
        System.out.println(capitalized);

        char[] chars = {'A', 'B', 'C'};
        String charsStr = new String(chars);
        System.out.println(charsStr);
        StringBuilder sb = new StringBuilder(name);
        sb.reverse();
        String reversed = sb.toString();
        System.out.println(reversed);

        String strDemo = "   Ivan    "; // => "Ivan"
        System.out.println(strDemo.trim());

        String[] parts = str.split("_");
        String firstName2 = parts[0];
        String lastName2 = parts[1];
        System.out.println(firstName2);
        System.out.println(lastName2);

        String strDemo2 = "   Ivan , Ivanov ";
        String strDemo2Normalized = strDemo2.replaceAll(" ", "");
        System.out.println(strDemo2Normalized);
        System.out.println(strDemo2Normalized.length());
    }

    public static void filterTrack(String[] tracks) {
        for(int i = 0; i < tracks.length; i++) {
            String digits = cutLastDigitsVer4(tracks[i]);
            int number = Integer.parseInt(digits);
            if (number >= 10 && number <= 15) {
                System.out.println(tracks[i]);
            }
        }
    }

    public static String cutLastDigits(String track) {
//        track.substring(6);
        return track.substring("track_".length());
    }

    public static String cutLastDigitsVer2(String track) {
        int index = track.indexOf("_");
        return track.substring(index + 1);
    }

    public static String cutLastDigitsVer3(String track) {
        int index = track.length() - 2;
        return track.substring(index);
    }

    public static String cutLastDigitsVer4(String track) {
        return track.replaceFirst("track_", "");
    }

    public static int countSymb(String str, String sub) {
        return 0;
    }
}
