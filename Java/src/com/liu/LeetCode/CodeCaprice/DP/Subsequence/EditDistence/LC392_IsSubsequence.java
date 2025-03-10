package com.liu.LeetCode.CodeCaprice.DP.Subsequence.EditDistence;

// 编辑距离入门题目
public class LC392_IsSubsequence {

    // Beats 93.03%
    private static boolean isSubsequenceMy1(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if (lengthS > lengthT) {
            return false;
        }
        if (lengthS == 0) {
            return true;
        }
        int indexS = 0;
        int indexT = 0;
        while (indexS < lengthS && indexT < lengthT) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
            }
            indexT++;
        }
        return indexS == lengthS;
    }

    // DP
    // Beats 4.06%
    private static boolean isSubsequenceMy2(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if (lengthS > lengthT) {
            return false;
        }
        if (lengthS == 0) {
            return true;
        }
        int[][] dp = new int[lengthS + 1][lengthT + 1];
        for (int i = 1; i <= lengthS; i++) {
            for (int j = 1; j <= lengthT; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[lengthS][lengthT] == lengthS;
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "acb",
                "abcde",
                "abc",
                "abc",
                "abc",
                "axc",
        };
        String[] tSet = new String[]{
                "ahbgdc",
                "ace",
                "abc",
                "ahbgdc",
                "def",
                "ahbgdc",
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = isSubsequenceMy1(sSet[i], tSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("isSubsequence My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = isSubsequenceMy2(sSet[i], tSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("isSubsequence My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
