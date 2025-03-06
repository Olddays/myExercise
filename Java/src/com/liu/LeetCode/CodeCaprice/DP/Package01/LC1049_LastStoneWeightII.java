package com.liu.LeetCode.CodeCaprice.DP.Package01;

import java.util.*;

public class LC1049_LastStoneWeightII {

    // 找到最小left，那就每一次都是最相近的砸，换句话说，既然是两两相撞，那么就是让石头分两堆，这两堆尽可能相似就能得到最小
    // 也就是根416题思路差不多，但是dp的定义不一样
    // Beats 57.94%
    private static int lastStoneWeightIIMy1(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // dp[j]表示容量为j的背包所能装的最大容量
        int[] dp = new int[sum / 2 + 1];
        for (int stone : stones) {
            for (int j = sum / 2; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        // 算出来的是最平均的情况，那么差距就是sum减去最平均的情况的两倍
        return sum - dp[sum / 2] * 2;
    }

    // 这个算的最大可能，所以是差距最大的相互砸
    private static int lastStoneWeightIIMy2(int[] stones) {
        int length = stones.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            minHeap.add(stone);
            maxHeap.add(stone);
        }
        while (length > 1) {
            int min = minHeap.poll();
            int max = maxHeap.poll();
            minHeap.remove(max);
            maxHeap.remove(min);
            int cache = max - min;
            if (cache > 0) {
                minHeap.add(cache);
                maxHeap.add(cache);
            }
            length--;
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void main(String[] args) {
        int[][] stonesSet = new int[][]{
                {2, 2},
                {2, 7, 4, 1, 8, 1},
                {31, 26, 33, 21, 40},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < stonesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = lastStoneWeightIIMy1(stonesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lastStoneWeightII My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < stonesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = lastStoneWeightIIMy2(stonesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lastStoneWeightII My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
