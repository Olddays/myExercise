package com.liu.LeetCode.CodeCaprice.DP;

public class LC063_UniquePathsII {

    private static int uniquePathsWithObstaclesMy1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][][] obstacleGridSet = new int[][][]{
                {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
                {{0, 1}, {0, 0}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < obstacleGridSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = uniquePathsWithObstaclesMy1(obstacleGridSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("uniquePathsWithObstacles My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
