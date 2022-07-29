package com.company.university;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Univer {

    public static int countNumber(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            try {
                Integer.parseInt(String.valueOf(s.charAt(i)));
                count++;
            } catch (NumberFormatException e) {
                //
            }
        }
        return count;

    }


    public static void leksikator(String fileName) {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String str[] = data.split(" ");
                for (String s : str) {
                    System.out.println(s);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String convertCyrilic(String message) {
        char[] abcCyr = {' ', 'Й', 'й', 'а', 'б', 'в', 'г', 'д', 'ѓ', 'е', 'ж', 'з', 'ѕ', 'и', 'ј', 'к', 'л', 'љ', 'м', 'н', 'њ', 'о', 'п', 'р', 'с', 'т', 'ќ', 'у', 'ф', 'х', 'ц', 'ч', 'џ', 'ш', 'А', 'Б', 'В', 'Г', 'Д', 'Ѓ', 'Е', 'Ж', 'З', 'Ѕ', 'И', 'Ј', 'К', 'Л', 'Љ', 'М', 'Н', 'Њ', 'О', 'П', 'Р', 'С', 'Т', 'Ќ', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Џ', 'Ш', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '/', '-'};
        String[] abcLat = {" ", "Y", "y", "a", "b", "v", "g", "d", "]", "e", "j", "z", "y", "i", "j", "k", "l", "q", "m", "n", "w", "o", "p", "r", "s", "t", "'", "u", "f", "h", "c", ";", "x", "{", "A", "B", "V", "G", "D", "}", "E", "J", "Z", "Y", "I", "J", "K", "L", "Q", "M", "N", "W", "O", "P", "R", "S", "T", "Q", "U", "F", "H", "C", ":", "X", "{", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "/", "-"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            for (int x = 0; x < abcCyr.length; x++) {
                if (message.charAt(i) == abcCyr[x]) {
                    builder.append(abcLat[x]);
                }
            }
        }
        return builder.toString();
    }

    private static String convertFileCyrlic(String filePath) {
        String data = "";
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return convertCyrilic(data);
    }

    private static String convertFileString(String filePath) {
        String data = "";
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {

        int a = 5;
        int b = 4;
        int c;
        c = a + b;
        System.out.println(c);

    }
}
