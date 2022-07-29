package com.company.university;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeksikAnalizator {
    static String[] keyWords = {"int", "boolean", "char", "double", "System", "out", "println"};
    static char[] numeral = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] separators = {',', ';', ':', '(', ')', '.'};
    static char[] assignment = {':', '=',};
    static char[] operators = {'+', '-', '*', '/'};
    static String[] strings = {"a o'zgaruvchi yaratildi", "b o'zgaruvchi yaratildi", "c o'zgaruvchi yaratildi", "c o'zgaruvchi hisoblandi", "c o'zgaruvchi chop qilindi",};

    private static boolean isKeyword(String s) {
        if (s.length() > 1) {
            for (String keyWord : keyWords) {
                if (s.toLowerCase().equals(keyWord)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isAssignment(String s) {
        if (s.length() == 1) {
            for (char ch : assignment) {
                if (s.charAt(0) == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isOperator(String s) {
        if (s.length() == 1) {
            for (char ch : operators) {
                if (s.charAt(0) == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isNumeral(String s) {
        if (s.length() == 1) {
            for (char ch : numeral) {
                if (s.charAt(0) == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSeparator(String s) {
        if (s.length() == 1) {
            for (char ch : separators) {
                if (s.charAt(0) == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isVariable(String s) {
        if (!isOperator(s)) {
            return s.length() >= 1 && s.length() <= 8;
        }
        return false;
    }

    private static void syntaxAnalyzer(String path) {

        String data;
        ArrayList<String> list = new ArrayList<String>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                list.add(data);

            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + "-> " + strings[i]);
        }

    }

    private static String analizator(String s) {
        StringBuilder builder = new StringBuilder();
        String[] strings = s.split(" ");
        for (String string : strings) {
//            System.out.println(strings[i]);
            if (isKeyword(string)) {

                System.out.println(string + " -> is keyword");
            } else if (isAssignment(string)) {
                System.out.println(string + " -> is assignment");
            } else if (isNumeral(string)) {
                System.out.println(string + " -> is numeral");
            } else if (isSeparator(string)) {
                System.out.println(string + " -> is separator");
            } else if (isVariable(string)) {
//                if (!syntaxAnalyzer(string)) {
//                    builder.append("!").append(string).append("!\n");
//                }
                System.out.println(string + " -> is variable");
            } else if (isOperator(string)) {
                System.out.println(string + " -> is operator");
            } else {
//                System.out.println(strings[i] + " -> idfdfbdfbdf");
                matcher(string);

            }

        }
        return builder.toString();
    }

    private static void matcher(String s) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            analizator(matcher.group());
        }
    }

    private static String convertFileString(String path) {
        String data;
        StringBuilder builder = new StringBuilder();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                builder.append(data).append("\n");
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        syntaxAnalyzer("src/text");
    }
}
