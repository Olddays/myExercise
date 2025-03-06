package com.liu.LeetCode.CodeCaprice.Array;

import java.util.*;

public class LC1046_LastStoneWeight {

    // 大端序 Beats 4.36%
    private static int lastStoneWeightMy1(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a != b) {
                queue.add(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    // Beats 97.70%
    private static int lastStoneWeightMy2(int[] stones) {
        // 唯一的区别就是Collections.reverseOrder()改成了lambda表达式
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a != b) {
                queue.add(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public static void main(String[] args) {
        int[][] stonesSet = new int[][]{
                {2, 2},
                {2, 7, 4, 1, 8, 1},
                {1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < stonesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = lastStoneWeightMy1(stonesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lastStoneWeight My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < stonesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = lastStoneWeightMy2(stonesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lastStoneWeight My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
