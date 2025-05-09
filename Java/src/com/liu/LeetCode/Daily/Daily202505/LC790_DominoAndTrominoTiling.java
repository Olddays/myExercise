package com.liu.LeetCode.Daily.Daily202505;

public class LC790_DominoAndTrominoTiling {

    // DP算法
    // Beats 42.40%
    private static int numTilingsMy1(int n) {
        if (n <= 2) {
            return n;
        }

        int mod = 1_000_000_007;
        long[] fullTiling = new long[n + 1];
        long[] partTiling = new long[n + 1];

        // One tile vertical can fill a pair of cells (or 1 column)
        fullTiling[1] = 1;
        // 2 vertical and 2 horizontals can fill up 2 pair of cells (or 2 columns)
        fullTiling[2] = 2;

        // Cannot fill one cell (in a column) with either domino or tromino
        partTiling[1] = 0;
        // If 1 cell out of 4 (2 pair of cells) is already filled then a tromino can fill the remaining 3 cells
        partTiling[2] = 1;

        for (int i = 3; i <= n; i++) {
            fullTiling[i] = (fullTiling[i - 1] + fullTiling[i - 2] + 2 * partTiling[i - 1]) % mod;
            partTiling[i] = (partTiling[i - 1] + fullTiling[i - 2]) % mod;
        }
        return (int) (fullTiling[n]);
    }

    private static int numTilingsAnswer1(int n) {
        long[] dp = new long[n + 3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        for (int i = 3; i < n; i ++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
        return (int)dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                3,
                1,
        };
        int[] resultList = new int[]{
                5,
                1,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numTilingsMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numTilings My1 result" + i + " " + result + " result " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numTilingsAnswer1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numTilings Answer1 result" + i + " " + result + " result " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
