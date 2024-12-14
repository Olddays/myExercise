package com.liu.LeetCode.Daily.Daily202412;

import java.util.*;

public class LC2558_TakeGiftsFromTheRichestPile {
    // 性能差Beats5.76% 时间复杂度O(n方logn)
    private static long pickGiftsMy1(int[] gifts, int k) {
        long result = 0;
        int n = gifts.length;
        for (int i = 0; i < k; i++) {
            Arrays.sort(gifts);
            gifts[n - 1] = (int) Math.sqrt(gifts[n - 1]);
        }
        for (int gift : gifts) {
            result += gift;
        }
        return result;
    }

    // 改用大堆，先出最大值 Beats89.83% 时间复杂度O(nlogn)
    private static long pickGiftsMy2(int[] gifts, int k) {
        long result = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int gift : gifts) {
            maxHeap.add(gift);
        }
        for (int i = 0; i < k; i++) {
            int max = maxHeap.poll();
            maxHeap.add((int) Math.sqrt(max));
        }
        while (!maxHeap.isEmpty()) {
            result += maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] giftsSet = new int[][]{
                {25, 64, 9, 4, 100},
                {1, 1, 1, 1},
        };
        int[] kSet = new int[]{
                4,
                4,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < giftsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = pickGiftsMy1(giftsSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("pickGifts My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
        giftsSet = new int[][]{
                {25, 64, 9, 4, 100},
                {1, 1, 1, 1},
        };
        for (int i = 0; i < giftsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = pickGiftsMy2(giftsSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("pickGifts My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
