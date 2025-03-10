package com.liu.LeetCode.CodeCaprice.DP.Subsequence.Palindromic;

public class LC516_LongestPalindromicSubsequence {
    // Beats 76.11%
    private static int longestPalindromeSubseqMy1(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        // dp[i][j] 表示s[i:j]的最长回文子序列长度
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) { // j=i+1，因为i=j已经在初始化的时候处理了
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 考虑前或考虑后
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][length - 1];
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "bbbab",
                "cbbd",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = longestPalindromeSubseqMy1(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("longestPalindromeSubseq My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
