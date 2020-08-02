package com.liu.LeetCode.First.exercise;

/**
 * Created by Liu on 2020/7/22.
 */
public class LC115_DistinctSubsequences {

    public static int numDistinct(String s, String t) {
        // array creation
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // filling the first row: with 1s
        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        return dp[t.length()][s.length()];
    }
}
