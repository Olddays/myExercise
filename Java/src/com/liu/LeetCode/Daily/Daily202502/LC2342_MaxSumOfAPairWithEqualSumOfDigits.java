package com.liu.LeetCode.Daily.Daily202502;

import java.util.*;

public class LC2342_MaxSumOfAPairWithEqualSumOfDigits {

    // force
    // Time Limit Exceeded, of course
    private static int maximumSumMy1(int[] nums) {
        int length = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < length; i++) {
            int digitSum = countDigitSum(nums[i]);
            List<Integer> list = map.getOrDefault(digitSum, new ArrayList<>());
            if (!list.isEmpty()) {
                for (int num : list) {
                    max = Math.max(max, num + nums[i]);
                }
            }
            list.add(nums[i]);
            map.put(digitSum, list);
        }
        return max;
    }

    private static int countDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // 优化掉Map中的list
    // Beats 88.23%
    private static int maximumSumMy2(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int num : nums) {
            int digitSum = countDigitSum(num);
            int preNum = map.getOrDefault(digitSum, -1);
            if (preNum != -1) {
                max = Math.max(max, preNum + num);
            }
            if (preNum < num) {
                map.put(digitSum, num);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {18, 43, 36, 13, 7},
                {10, 12, 19, 14},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maximumSumMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumSum My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maximumSumMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumSum My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
