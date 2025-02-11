package com.liu.LeetCode.Daily.Daily202502;

import java.util.HashMap;
import java.util.Map;

public class LC2364_CountNumberOfBadPairs {
    // Time Limit Exceeded
    // 我就说不会那么简单
    private static long countBadPairsMy1(int[] nums) {
        int length = nums.length;
        long count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[j] - nums[i] != j - i) {
                    count++;
                }
            }
        }
        return count;
    }

    // j-i != nums[j]-nums[i]
    // j-nums[j] != i-nums[i]
    // 其中 i-nums[i]存在了map里面，每次读j-num[j]时，比较一下看看map里面有几个和自己不相等的i-nums[i]，然后加入count里面
    // Beats 97.65%
    private static long countBadPairsAnswer1(int[] nums) {
        int length = nums.length;
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int previous = map.getOrDefault(i - nums[i], 0);
            count += i - previous;
            map.put(i - nums[i], previous + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {4, 1, 3, 3},
                {1, 2, 3, 4, 5},
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countBadPairsMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countBadPairs My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countBadPairsAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countBadPairs Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
