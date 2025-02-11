package com.liu.LeetCode.Daily.Daily202502;

import java.util.*;

public class LC3160_FindTheNumberOfDistinctColorsAmongTheBalls {

    // Memory Limit Exceeded
    // 考虑将balls优化掉
    private static int[] queryResultsMy1(int limit, int[][] queries) {
        int length = queries.length;
        int[] result = new int[length];
        int[] balls = new int[limit + 1];
        Map<Integer, Integer> colorCount = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            int ball = query[0];
            int color = query[1];
            int oldColor = balls[ball];
            if (oldColor != 0) {
                int count = colorCount.get(oldColor) - 1;
                if (count == 0) {
                    colorCount.remove(oldColor);
                } else {
                    colorCount.put(oldColor, count);
                }
            }
            balls[ball] = color;
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            result[i] = colorCount.size();
        }
        return result;
    }

    // Beats 20.96%
    // hash比int（的最坏情况）占空间少
    private static int[] queryResultsMy2(int limit, int[][] queries) {
        int length = queries.length;
        int[] result = new int[length];
        Map<Integer, Integer> balls = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            int ball = query[0];
            int color = query[1];
            int oldColor = balls.getOrDefault(ball, 0);
            if (oldColor != 0) {
                int count = colorCount.get(oldColor) - 1;
                if (count == 0) {
                    colorCount.remove(oldColor);
                } else {
                    colorCount.put(oldColor, count);
                }
            }
            balls.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            result[i] = colorCount.size();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] limitList = new int[]{
                1,
                4,
                4,
        };
        int[][][] queriesList = new int[][][]{
                {{0, 2}, {1, 10}, {0, 10}, {0, 3}, {1, 5}},
                {{1, 4}, {2, 5}, {1, 3}, {3, 4}},
                {{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < limitList.length; i++) {
            startTime = System.currentTimeMillis();
            result = queryResultsMy1(limitList[i], queriesList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("queryResults My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < limitList.length; i++) {
            startTime = System.currentTimeMillis();
            result = queryResultsMy2(limitList[i], queriesList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("queryResults My2 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
