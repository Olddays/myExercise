package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC2563_CountTheNumberOfFairPairs {

    // Time Limit Exceeded
    private static long countFairPairsMyError1(int[] nums, int lower, int upper) {
        int length = nums.length;
        long result = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                if (sum >= lower && sum <= upper) {
                    result++;
                }
            }
        }
        return result;
    }

    // nums[i]+nums[j] == nums[j]+nums[i]，所以i<j其实就是i!=j，所以是可以排序的
    // Beats 78.66%
    private static long countFairPairsMy1(int[] nums, int lower, int upper) {
        int length = nums.length;
        long result = 0;
        Arrays.sort(nums);
        // 把问题转化为，合小于upper的，减去合小于lower-1的
        // 用for不用while是因为我懒得抽象一个新函数，把left和right重新赋值回去又显得很乱
        for (int i = 0, j = length - 1; i < j; i++) {
            while (i < j && nums[i] + nums[j] > upper) {
                j--;
            }
            result += j - i;
        }
        for (int i = 0, j = length - 1; i < j; i++) {
            while (i < j && nums[i] + nums[j] > lower - 1) {
                j--;
            }
            result -= j - i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {0, 1, 7, 4, 4, 5},
                {1, 7, 9, 2, 5},
        };
        int[] lowerList = new int[]{
                3,
                11,
        };
        int[] upperList = new int[]{
                6,
                11,
        };
        long[] resultList = new long[]{
                6,
                1,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countFairPairsMy1(numsList[i], lowerList[i], upperList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countFairPairs My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
