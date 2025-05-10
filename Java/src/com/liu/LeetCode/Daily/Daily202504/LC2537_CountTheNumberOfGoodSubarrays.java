package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC2537_CountTheNumberOfGoodSubarrays {

    private static long countGoodMy1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0;
        int left = 0;
        for (int num : nums) {
            k -= map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1); // 找相等，所以从左往右计数
            while (k <= 0) {
                map.put(nums[left], map.get(nums[left]) - 1);
                k += map.get(nums[left++]);
            }
            cnt += left;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 1, 1, 1, 1},
                {3, 1, 4, 3, 2, 2, 4},
        };
        int[] kList = new int[]{
                10,
                2,
        };
        long[] resultList = new long[]{
                1,
                4,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countGoodMy1(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countGood My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
