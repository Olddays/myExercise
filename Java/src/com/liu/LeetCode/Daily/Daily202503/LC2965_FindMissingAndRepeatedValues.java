package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC2965_FindMissingAndRepeatedValues {

    // Beats 100.00%
    private static int[] findMissingAndRepeatedValuesMy1(int[][] grid) {
        int n = grid.length;
        int[] result = new int[2];
        boolean[] visited = new boolean[n * n + 1];
        for (int[] line : grid) {
            for (int val : line) {
                if (visited[val]) {
                    result[0] = val;
                }
                visited[val] = true;
            }
        }
        for (int i = 1; i < n * n + 1; i++) {
            if (!visited[i]) {
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][][] gridList = new int[][][]{
                {{1, 3}, {2, 2}},
                {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < gridList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findMissingAndRepeatedValuesMy1(gridList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("findMissingAndRepeatedValues My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
