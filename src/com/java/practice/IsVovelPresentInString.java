package com.java.practice;

import java.util.Locale;

/*

 */
public class IsVovelPresentInString {
    public static void main(String[] args) {
        String s = "Hello";
        boolean isVowel = isStringContainsVowels(s);
        if (isVowel) System.out.println("Yes");
        else System.out.println("No");

    }

    private static boolean isStringContainsVowels(String s) {
        return s.toLowerCase().matches(".*[aeiou].*");
    }
}
