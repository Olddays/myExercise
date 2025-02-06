package com.liu.LeetCode.Daily.Daily202412;

import java.util.*;

public class LC3264_FinalArrayStateAfterKMultiplicationOperationsI {

    // 一看到最小翻倍，就让我想到大小堆，但是此大小堆只能评估一个数据，所以没办法处理有多个一样最小值时候的变化问题
    // 不满足题目的，多个一样最小时，选择第一个的要求
    // 如果使用数值num作为key，位置i作为位置，会很复杂，因为key要变化，value也要变化，还需要评估堆里面有没有这个key并且处理
    private static int[] getFinalStateMy1(int[] nums, int k, int multiplier) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            int key = entry.getKey();
            int value = entry.getValue() * multiplier;
            entry.setValue(value);
            nums[key] = value;
            maxHeap.add(entry);
        }
        return nums;
    }

    private static int[] getFinalStateMy2(int[] nums, int k, int multiplier) {
        int min = Integer.MAX_VALUE;
        int index = nums.length - 1;
        for (int round = 0; round < k; round++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    index = i;
                }
            }
            nums[index] = min * multiplier;
            min = Integer.MAX_VALUE;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {2, 1, 3, 5, 6},
                {1, 2},
        };
        int[] kSet = new int[]{
                5,
                3,
        };
        int[] multiplierSet = new int[]{
                2,
                4,
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = getFinalStateMy1(numsSet[i], kSet[i], multiplierSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("getFinalState My1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        numsSet = new int[][]{
                {2, 1, 3, 5, 6},
                {1, 2},
        };
        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = getFinalStateMy2(numsSet[i], kSet[i], multiplierSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("getFinalState My2 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
