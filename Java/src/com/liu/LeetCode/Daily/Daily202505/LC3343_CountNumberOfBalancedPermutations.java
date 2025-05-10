package com.liu.LeetCode.Daily.Daily202505;

public class LC3343_CountNumberOfBalancedPermutations {
    // backtrace 一定会超时，用dp尝试

    // Beats 75.00%
    private static int countBalancedPermutationsMy1(String num) {
        final int mod = 1_000_000_007;
        int n = num.length();
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += c - '0';
        }
        if ((sum & 1) == 1) {
            return 0;
        }

        long[] inv = new long[n + 1];
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = inv[0] = invFact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }
        inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            inv[i] = mod - (mod / i) * inv[mod % i] % mod;
        }
        for (int i = 1; i <= n; i++) {
            invFact[i] = invFact[i - 1] * inv[i] % mod;
        }

        int halfSum = sum / 2, halfLen = n / 2;
        int[][] dp = new int[halfSum + 1][halfLen + 1];
        dp[0][0] = 1;
        int[] digits = new int[10];
        for (char c : num.toCharArray()) {
            int d = c - '0';
            digits[d]++;
            for (int i = halfSum; i >= d; i--) {
                for (int j = halfLen; j > 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i - d][j - 1]) % mod;
                }
            }
        }
        long result = dp[halfSum][halfLen];
        result = result * fact[halfLen] % mod * fact[n - halfLen] % mod;
        for (int count : digits) {
            result = result * invFact[count] % mod;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        String[] numList = new String[]{
                "123",
                "112",
                "12345",
        };
        int[] resultList = new int[]{
                2,
                1,
                0,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countBalancedPermutationsMy1(numList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countBalancedPermutations My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
