package com.liu.LeetCode.CodeCaprice.DP.Package01;

public class LC474_OnesAndZeroes {

    // 01背包问题
    // 背包容量是m和n，物品是strs，物品的价值是1，物品的重量是strs中0和1的个数
    // dp[i][j]表示背包容量为i个0和j个1时，最多可以装下的物品数量
    // dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)
    // 三维背包
    // Beats 96.02%
    private static int findMaxFormMy1(String[] strs, int m, int n) {
        // dp[i][j]表示背包容量为i个0和j个1时，最多可以装下的str数量
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int zeroes = 0;
            int ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                    // +1, 因为当前的str已经被选中了
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[][] strsSet = new String[][]{
                {"10", "0001", "111001", "1", "0"},
                {"10", "0", "1"},
        };
        int[] mSet = new int[]{
                5,
                1,
        };
        int[] nSet = new int[]{
                3,
                1,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < strsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findMaxFormMy1(strsSet[i], mSet[i], nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findMaxForm My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
