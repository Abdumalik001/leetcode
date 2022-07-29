package com.company.binarysearch;

public class NoisyPalindrome {
    public static boolean solve(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                str += s.charAt(i);
            }
        }

        return isPalindrome(str);
    }
    public static boolean isPalindrome(String str) {
        String rev = "";
        boolean isPalindrome = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        if (str.equals(rev)) {
            isPalindrome = true;
        }
        return isPalindrome;
    }


    public static void main(String[] args) {


        boolean A = solve("ed");
        System.out.println(A);
    }

}
