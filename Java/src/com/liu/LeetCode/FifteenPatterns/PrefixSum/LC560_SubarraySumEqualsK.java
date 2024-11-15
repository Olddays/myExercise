package com.liu.LeetCode.FifteenPatterns.PrefixSum;

import java.util.HashMap;

public class LC560_SubarraySumEqualsK {

    private static int subarraySumMy1(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        if (length == 0) return result;
        // sum(i, j) = sum(0, j) - sum(0, i)
        HashMap<Integer, Integer> cacheMap = new HashMap<>();
        int sum = 0;
        cacheMap.put(0, 0);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            cacheMap.put(i + 1, sum);
        }
        for (HashMap.Entry<Integer, Integer> entry : cacheMap.entrySet()) {
            int cache = entry.getValue() - k;
            if (cacheMap.containsValue(cache)) {
                result++; // 不一定只有一个
            }
        }
        return result;
    }

    private static int subarraySumMy2(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        if (length == 0) return result;
        // sum(i, j) = sum(0, j) - sum(0, i)
        HashMap<Integer, Integer> cacheMap = new HashMap<>();
        int sum = 0;
        cacheMap.put(sum, 1);
        for (int num : nums) {
            sum += num;
            if (cacheMap.containsKey(sum)) {
                cacheMap.put(sum, cacheMap.get(sum) + 1);
            } else {
                cacheMap.put(sum, 1);
            }
        }
        // 这里有问题，应该在第一次循环的时候记录，否则就会被重复计算
        for (HashMap.Entry<Integer, Integer> entry : cacheMap.entrySet()) {
            int cache = entry.getKey() - k;
            if (cacheMap.containsKey(cache)) {
                result += Math.max(cacheMap.get(cache), entry.getValue());
            }
        }
        return result;
    }

    private static int subarraySumAnswer1(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        if (length == 0) return result;
        HashMap<Integer, Integer> cacheMap = new HashMap<>();
        int sum = 0;
        cacheMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (cacheMap.containsKey(sum - k)) {
                result += cacheMap.get(sum - k);
            }
            if (cacheMap.containsKey(sum)) {
                cacheMap.put(sum, cacheMap.get(sum) + 1);
            } else {
                cacheMap.put(sum, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, -1},
                {3, 4, 7, -2, 2, 1, 4, 2},
                {1, 1, 1},
                {1, 2, 3},
        };
        int[] ks = new int[]{
                0,
                7,
                2,
                3,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = subarraySumMy1(numsList[i], ks[i]);
            endTime = System.currentTimeMillis();
            System.out.println("SubarraySumEqualsK My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = subarraySumMy2(numsList[i], ks[i]);
            endTime = System.currentTimeMillis();
            System.out.println("SubarraySumEqualsK My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = subarraySumAnswer1(numsList[i], ks[i]);
            endTime = System.currentTimeMillis();
            System.out.println("SubarraySumEqualsK Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
