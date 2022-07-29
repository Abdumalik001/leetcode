package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringsLeetCode {
    public String reverseWords(String s) {
        String[] a = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            StringBuilder b = new StringBuilder();
            b.append(a[i]);
            if (i == 0) {
                builder.append(b.reverse());
            } else {
                builder.append(" ").append(b.reverse());
            }
        }
        return builder.toString();
    }

    public String freqAlphabets(String s) {
        List<Character> list = new ArrayList<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                String str = String.valueOf(s.charAt(i - 2)) + String.valueOf(s.charAt(i - 1));
                int val = Integer.parseInt(str);
                list.add((char) (val + 96));
                i -= 2;
            } else {
                String str2 = String.valueOf(s.charAt(i));
                int val2 = Integer.parseInt(str2);
                list.add((char) (val2 + 96));
            }
        }
        StringBuilder alpha = new StringBuilder();
        for (int k = list.size() - 1; k >= 0; k--) {
            alpha.append(list.get(k));
        }

        return alpha.toString();
    }

    public int numOfStrings(String[] patterns, String word) {
        int k = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])) {
                k++;
            }
        }
        return k;
    }

    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (solution(words[i])) return words[i];
        }
        return "";

    }

    boolean solution(String inputString) {
        int val = inputString.length();
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == inputString.charAt(val - i - 1)) {
                count++;
            }
        }
        return (count == val);
    }

    public static String removeOuterParenthese(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (st.size() != 0) {
                    ans.append("(");
                }
                st.push(ch);
            } else {
                st.pop();

                if (st.size() != 0) {
                    ans.append(")");
                }
            }
        }
        return ans.toString();
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        // s = "(()())(())(()(()))"
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (stack.size() != 0) {
                    builder.append(s.charAt(i));
                }
                stack.push(String.valueOf(s.charAt(i)));
            }
            if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.size() != 0) {
                    builder.append(s.charAt(i));
                }
            }
        }

        return builder.toString();
    }

    public static String replaceDigits(String s) {
        StringBuilder builder = new StringBuilder();
//        s = "a1b2c3d4e"

        for (int i = 1; i < s.length(); i += 2) {
            builder.append(String.valueOf(s.charAt(i - 1)));
            builder.append(shift(s.charAt(i - 1), Integer.parseInt(String.valueOf(s.charAt(i)))));
        }
        if (s.length() % 2 == 1) {
            builder.append(s.charAt(s.length() - 1));
        }
        return builder.toString();

    }

    public static String shift(char s, int index) {
        if (index == 0) {
            return String.valueOf(s);
        }
        return String.valueOf((char) ((int) s + index));
    }

    public static void main(String[] args) {
//        System.out.println("Hello");
//        System.out.println(shift('d', 4));
//        System.out.println(replaceDigits("a1b2c3d4e"));
        System.out.println(removeOuterParentheses("(()())(())"));
    }
}
