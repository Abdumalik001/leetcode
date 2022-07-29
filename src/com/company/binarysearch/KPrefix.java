package com.company.binarysearch;

public class KPrefix {
    public static int solve(int[] nums, int k) {
        //[3, -5, 4, 1, 6], 4
        int maxNum = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            maxNum += nums[i];
            if (maxNum <= k) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int a[] = {3, -5, 4, 1, 6};
        System.out.println(solve(a, 4));
    }
}

//[0,-1],
//40,-39
//[1,1] 0 ->-1
