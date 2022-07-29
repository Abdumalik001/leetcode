package com.company.binarysearch;

import java.util.Arrays;
import java.util.Collections;

public class ListMinReplacement {
    public static int[] solve(int[] nums) {
        int[] b = new int[nums.length];
        int minNUmber = nums[0];
        b[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= minNUmber) {
                minNUmber = nums[i];
            }
            b[i + 1] = minNUmber;
        }
        return b;
    }

    public static void main(String[] args) {
        int a[] = {10, 5, 7, 9};
        System.out.println(Arrays.toString(solve(a)));
    }
}
