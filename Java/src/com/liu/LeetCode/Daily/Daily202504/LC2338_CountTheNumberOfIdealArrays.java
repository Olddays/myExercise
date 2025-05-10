package com.liu.LeetCode.Daily.Daily202504;

public class LC2338_CountTheNumberOfIdealArrays {
    // 取值是0到maxValue，每个值都可以被前一个值整除
    // dp[n][maxValue] dp[v][k]最大值为v且长度为k的情况下的值数量
    // 当i*j<v的时候，dp[k+1][i*j] += dp[k][i]
    // Beats 27.27%
    private static int idealArraysMy1(int n, int maxValue) {
        // step 1 ending number, length, unique plans
        // dp[n][maxValue] dp[v][k]最大值为v且长度为k的情况下的值数量
        int MOD = (int) 1e9 + 7;
        long[][] dp = new long[maxValue + 1][15]; // 15 is due to 2^13 < 10000,   2^14 > 10000, total possible max length is 14
        for (int i = 1; i <= maxValue; i++) { // n最小为2
            dp[i][1] = 1; // 长度为1，最大值为任意值，那就全都是1
        }
        for (int j = 1; j < 14; j++) {
            // current state ending
            for (int i = 1; i <= maxValue; i++) {
                // next state ending
                for (int k = 2; i * k <= maxValue; k++) {
                    dp[k * i][j + 1] = (dp[i][j] + dp[k * i][j + 1]) % MOD;
                }
            }
        }

        // step 2 combination
        long[][] combineDp = new long[n][15];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 15 && j <= i; j++) {
                if (j == 0) combineDp[i][j] = 1;
                else combineDp[i][j] = (combineDp[i - 1][j - 1] + combineDp[i - 1][j]) % MOD;
            }
        }

        // step 3 result
        long res = 0L;
        for (int i = 1; i <= maxValue; i++) {
            for (int j = 1; j <= 14 && j <= n; j++) {
                res = (res + dp[i][j] * combineDp[n - 1][j - 1]) % MOD;
            }
        }

        return (int) res;
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                2,
                5,
        };
        int[] maxValueList = new int[]{
                5,
                3,
        };
        int[] resultList = new int[]{
                10,
                11,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = idealArraysMy1(nList[i], maxValueList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("idealArrays My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
