package com.company.binarysearch;

public class Roomba {
    public static boolean solve(String[] moves, int x, int y) {
        if (moves.length == 0) {
            return x == 0 && y == 0;
        }
        int dx = 0;
        int dy = 0;
        for (String move : moves) {
            switch (move) {
                case "NORTH":
                    dy++;
                    break;
                case "SOUTH":
                    dy--;
                    break;
                case "WEST":
                    dx--;
                    break;
                default:
                    dx++;
                    break;
            }
        }
        return dx == x && dy == y;
    }

    public static void main(String[] args) {
        String[] a = {"NORTH", "EAST"};
        System.out.println(solve(a, 1, 0));
    }
}
