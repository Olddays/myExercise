package com.liu.LeetCode.CodeCaprice.DP.Subsequence.EditDistence;

public class LC583_DeleteOperationForTwoStrings {

    // Beats 76.80%
    private static int minDistanceMy1(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        // dp[i][j] 表示word1[0:i]和word2[0:j]的最长公共子序列长度
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return length1 + length2 - (dp[length1][length2] * 2);
    }

    private static int minDistanceMy2(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        // dp[i][j] 表示word1[0:i]和word2[0:j]的删除数量
        int[][] dp = new int[length1 + 1][length2 + 1];
        // 如果word2为空，word1要删掉所有字符，所以dp[i][0]=i
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        // 如果word1为空，word2要删掉所有字符，所以dp[0][j]=j
        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 2);
                    // j-1就是错过j，i-1就是错过i
                    // 所以不需要比较两个都删掉dp[i-1][j-1]的情况
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "park",
                "a",
                "sea",
                "leetcode",
        };
        String[] tSet = new String[]{
                "spake",
                "a",
                "eat",
                "etco",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = minDistanceMy1(sSet[i], tSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minDistance My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = minDistanceMy2(sSet[i], tSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minDistance My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
