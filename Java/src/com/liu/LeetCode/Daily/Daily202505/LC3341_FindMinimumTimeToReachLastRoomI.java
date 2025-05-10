package com.liu.LeetCode.Daily.Daily202505;

import java.util.*;

public class LC3341_FindMinimumTimeToReachLastRoomI {
    // 只考虑了下和右的情况，应该四个方向都考虑
    private static int minTimeToReachMyError1(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i - 1][0] < moveTime[i][0]) {
                dp[i][0] = moveTime[i][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for (int i = 1; i < m; i++) {
            if (dp[0][i - 1] < moveTime[0][i]) {
                dp[0][i] = moveTime[0][i] + 1;
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 下
                int down = dp[i][j - 1] + 1;
                if (down <= moveTime[i][j]) {
                    down = moveTime[i][j] + 1;
                }
                // 右
                int right = dp[i - 1][j] + 1;
                if (right <= moveTime[i][j]) {
                    right = moveTime[i][j] + 1;
                }
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[n - 1][m - 1];
    }

    // Beats 20.25%
    private static int minTimeToReachAnswer1(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minh = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minh.add(new int[]{0, 0, 0});
        moveTime[0][0] = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!minh.isEmpty()) {
            int[] current = minh.poll();
            int currTime = current[0];
            int currRow = current[1];
            int currCol = current[2];
            if (currTime >= dp[currRow][currCol]) {
                continue;
            }
            if (currRow == n - 1 && currCol == m - 1) {
                return currTime;
            }
            dp[currRow][currCol] = currTime;
            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m &&
                        dp[nextRow][nextCol] == Integer.MAX_VALUE) {
                    int nextTime = Math.max(moveTime[nextRow][nextCol], currTime) + 1;
                    minh.add(new int[]{nextTime, nextRow, nextCol});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][][] numsList = new int[][][]{
                {{94, 79, 62, 27, 69, 84}, {6, 32, 11, 82, 42, 30}},
                {{52, 74, 25}, {8, 44, 77}},
                {{15, 58}, {67, 4}},
                {{0, 0, 0}, {0, 0, 0}},
                {{0, 4}, {4, 4}},
                {{0, 1}, {1, 2}},
        };
        int[] resultList = new int[]{
                72,
                78,
                60,
                3,
                6,
                3,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minTimeToReachAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minTimeToReach Answer1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
