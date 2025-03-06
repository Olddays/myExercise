package com.liu.LeetCode.CodeCaprice.DP;

public class LC062_UniquePaths {

    private static int uniquePathsMy1(int m, int n) {
        // dp表示从0,0出发到每一个点的路径数量
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) { // 初始化第一列，第一列的路径数量都为1
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) { // 初始化第一行，第一行的路径数量都为1
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到达当前点的路径数量等于上方点和左方点的路径数量之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[] mSet = new int[]{
                3,
                3,
        };
        int[] nSet = new int[]{
                7,
                2,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < mSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = uniquePathsMy1(mSet[i], nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("uniquePaths My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
