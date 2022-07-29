package com.company.binarysearch;

public class StuckKeyboard {
    public static boolean solve(String typed, String target) {
        boolean b = true;
        if(typed.length()<target.length()){
            return false;
        }else{
            for (int i = 0; i < typed.length(); i++) {
                if (!target.contains(String.valueOf(typed.charAt(i)))) {
                    b = false;
                    break;
                }
            }
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(solve("a", "abc"));
    }
}
