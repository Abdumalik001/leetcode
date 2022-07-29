package com.company.binarysearch;

public class LongestConsecutiveDuplicateString {
    public static int solve(String s) {

        //abbbbbbaa
        int count = 0;
        int k = 0;
        if(s.isEmpty())return 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                k++;
                if (k >= count) {
                    count = k;
                }
            } else {
                k = 0;
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        System.out.println(solve("aabbbbabbbbbbadc"));
    }
}

