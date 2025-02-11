package com.liu.LeetCode.Daily.Daily202502;

import java.util.*;

public class LC1726_TupleWithSameProduct {

    // 每个组合是由abcd构成的，且abcd各不相同，那么abcd的排列组合有8个，所以结果一定是8的倍数
    // 核心是有多少个不同的abcd组合，再乘8即可
    // Beats 21.79%
    private static int tupleSameProductMy1(int[] nums) {
        // 先处理极端情况
        int count = 0;
        int length = nums.length;
        if (length < 4) {
            return count;
        }
        // 求两对数字的乘积相等，那么可以选择进行排序后，两侧夹逼
        Arrays.sort(nums);
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                int leftNum = nums[i];
                int rightNum = nums[j];
                int multi = leftNum * rightNum;
                List<int[]> list = map.getOrDefault(multi, new ArrayList<>());
                list.add(new int[]{leftNum, rightNum});
                map.put(multi, list);
            }
        }
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            int pairSize = entry.getValue().size();
            if (pairSize > 1) {
                count += pairSize * (pairSize - 1) / 2; // C(n,2)
            }
        }
        return count * 8;
    }

    // 精简的方向，一个是减少一个for循环，一个是把list改为count
    // Beats 81.41%
    private static int tupleSameProductMy2(int[] nums) {
        // 先处理极端情况
        int resultCount = 0;
        int length = nums.length;
        if (length < 4) {
            return resultCount;
        }
        // 求两对数字的乘积相等，那么可以选择进行排序后，两侧夹逼
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                int multi = nums[i] * nums[j];
                int count = map.getOrDefault(multi, 0);
                // 如果此时是第一次的multi，那么count是0，而每增加一个等于增加一个count，跟C(n,2)的规律一致
                resultCount += count;
                map.put(multi, count + 1);
            }
        }
        return resultCount * 8;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {2, 3, 4, 6},
                {1, 2, 4, 5, 10},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = tupleSameProductMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("tupleSameProduct My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = tupleSameProductMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("tupleSameProduct My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
