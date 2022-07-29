package com.company.hash_table;

import java.util.Map;

public class HashTab {
    public int countPoints(String rings) {
        int count = 0;

        return count;
    }

    public static boolean contains(String allowed, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!allowed.contains(String.valueOf(word.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String word : words) {
            if (contains(allowed, word)) {
                count++;
            }
        }
        return count;
    }

    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 6, 4, 8};
        System.out.println(countKDifference(a, 2));
    }
}
