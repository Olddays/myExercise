package com.liu.LeetCode.Daily.Daily202503;

import java.util.Arrays;

public class LC2033_MinimumOperationsToMakeAUni_ValueGrid {

    // 往中间凑是最快的，所以可以先算平均值，然后往中间凑
    // 这个题的难点在于，如何判断是否可以达成，因为可以加减x，所以平均值可能是小数，所以需要先判断是否可以达成
    // 然后，再计算每个位置的差值，然后累加
    // 不应该用average，边界很难处理
    private static int minOperationsMyError1(int[][] grid, int x) {
        int result = 0;
        int sum = 0;
        for (int[] line : grid) {
            for (int value : line) {
                sum += value;
            }
        }
        int size = grid.length * grid[0].length;
        int average = (int) Math.round((double) sum / size);
        int count = 0;
        for (int[] line : grid) {
            for (int value : line) {
                int diff = Math.abs(value - average);
                if (diff % x != 0) {
                    count += diff % x;
                }
                result += diff / x;
            }
        }
        if (count % size == 0) {
            return result + count / x;
        } else {
            return -1;
        }
    }

    // Beats 95.48%
    private static int minOperationsMy1(int[][] grid, int x) {
        int size = grid.length * grid[0].length;
        if (size <= 1) {
            return 0;
        }
        int last = grid[0][0] % x;
        int[] cacheGrid = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 一定要注意，这里是i * grid[0].length + j 而不是i * grid.length + j
                cacheGrid[i * grid[0].length + j] = grid[i][j] / x;
                if (grid[i][j] % x != last) { // 剩下的不一样，就无法达成
                    return -1;
                }
            }
        }
        Arrays.sort(cacheGrid);
        int average = cacheGrid[cacheGrid.length / 2];
        int count = 0;
        for (int val : cacheGrid) {
            count += Math.abs(val - average);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][][] gridList = new int[][][]{
                {{529, 529, 989}, {989, 529, 345}, {989, 805, 69}},
                {{146}},
                {{931, 128}, {639, 712}},
                {{2, 4}, {6, 8}},
                {{1, 5}, {2, 3}},
                {{1, 2}, {3, 4}},
        };
        int[] xList = new int[]{
                92,
                86,
                73,
                2,
                1,
                2,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < xList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minOperationsMy1(gridList[i], xList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minOperations My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
