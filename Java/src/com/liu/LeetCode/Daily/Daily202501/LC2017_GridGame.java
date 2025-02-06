package com.liu.LeetCode.Daily.Daily202501;

public class LC2017_GridGame {

    private static long gridGameMy1(int[][] grid) {
        long result = Long.MAX_VALUE;
        long top = 0;
        long bottom = 0;
        int length = grid[0].length;
        for (int i = 0; i < length; i++) {
            top += grid[0][i];
        }
        for (int i = 0; i < length; i++) { // 核心是找到啥时候往下走
            top -= grid[0][i];
            result = Math.min(result, Math.max(top, bottom));
            bottom += grid[1][i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][][] gridList = new int[][][]{
                {{1, 1, 1, 15}, {1, 3, 3, 1}},
                {{2, 5, 4}, {1, 5, 1}},
                {{3, 3, 1}, {8, 5, 2}},
                {{1, 3, 1, 15}, {1, 3, 3, 1}},
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < gridList.length; i++) {
            startTime = System.currentTimeMillis();
            result = gridGameMy1(gridList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("gridGame My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
