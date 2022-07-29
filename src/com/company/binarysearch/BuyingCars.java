package com.company.binarysearch;

import java.util.Arrays;

public class BuyingCars {
    public static int solve(int[] prices, int k) {
        Arrays.sort(prices);
        int n = 0;
        if (prices[0] > k) {
            return 0;
        }
        for (int i = 0; i < prices.length; i++) {
            if (k >= prices[i]) {
                k -= prices[i];
                n = i + 1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int a[] = {90, 30, 20, 40, 90};
        System.out.println(solve(a, 95));
    }
}
