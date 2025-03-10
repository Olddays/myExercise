package com.liu.LeetCode.CodeCaprice.DP.Subsequence;

public class LC1143_LongestCommonSubsequence {

    // Beats 75.32%
    private static int longestCommonSubsequenceMy1(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        // dp[i][j] 表示text1[0:i-1]和text2[0:j-1]的最长公共子序列长度
        // 用+1的方式避免了初始化
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 不相同时，将之前的状态传递下去
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 这里不需要max来记录，是因为有一个状态传递和max的判断将最大值传递了下去
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String[] text1Set = new String[]{
                "abcde",
                "abc",
                "abc",
        };
        String[] text2Set = new String[]{
                "ace",
                "abc",
                "def",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < text1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = longestCommonSubsequenceMy1(text1Set[i], text2Set[i]);
            endTime = System.currentTimeMillis();
            System.out.println("longestCommonSubsequence My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
