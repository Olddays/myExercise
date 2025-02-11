package com.liu.LeetCode.Second;

import java.util.*;

public class LC1814_CountNicePairsInAnArray {

    // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
    // nums[i] - rev(nums[i]) == nums[j] - rev(nums[j]).
    // Beats 15.72%
    private static int countNicePairsMy1(int[] nums) {
        final int mod = 1000000007;
        int length = nums.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int diff = nums[i] - reverse(nums[i]);
            if (map.containsKey(diff)) {
                result = (result % mod + map.get(diff) % mod) % mod;
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return result;
    }

    private static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int[][] numSet = {
                {42, 11, 1, 97},
                {13, 10, 35, 24, 76},
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < numSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = countNicePairsMy1(numSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countNicePairs My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
