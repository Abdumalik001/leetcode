package com.company.binarysearch;

public class RunLengthEncoding {
    public static String solve(String s) {
        StringBuilder result = new StringBuilder();
        ///aabbsss
        int count = 0;
        int index = 0;
        char sIndex = s.charAt(0);
        for (char element : s.toCharArray()) {
            if (sIndex == element) {
                count++;
                if (index == s.length()-1) {
                    result.append(count).append(sIndex);
                }
            } else {
                result.append(count).append(sIndex);
                count = 1;
            }
            sIndex = element;
            index++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("abadabbbsssssssaza"));
    }
}
