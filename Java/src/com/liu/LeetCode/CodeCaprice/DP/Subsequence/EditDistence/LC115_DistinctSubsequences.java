package com.liu.LeetCode.CodeCaprice.DP.Subsequence.EditDistence;

public class LC115_DistinctSubsequences {

    // 也就是问，有多少种删除的方式可以让s变成t
    // 也就是求s的子序列中t出现的个数
    // Beats 83.98%
    private static int numDistinctMy1(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if (lengthS < lengthT) {
            return 0;
        }
        // dp[i][j] 表示s的前i-1个字符中t的前j-1个字符出现的次数
        int[][] dp = new int[lengthS + 1][lengthT + 1];
        // 第一行第一列需要初始化，因为是从左上方往下推
        for (int i = 0; i <= lengthS; i++) {
            // 0表示比对用的t是空字符串，那么此时有且只有一种变化方法，就是给全删了
            dp[i][0] = 1;
        }
        // dp[0][j]的话，意思是s空t不空，那就只有0种情况
        for (int i = 1; i <= lengthS; i++) {
            for (int j = 1; j <= lengthT; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 如果当前字符相等，那么有两种情况
                    // 1. 不使用当前字符，那么就是dp[i-1][j]
                    // 2. 使用当前字符，那么就是dp[i-1][j-1]
                    // 只考虑s的删除，因为是求s中有多少t
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 不等于，那就是模拟删除s中的元素，也就是跳过s[i]
                    // 也就是dp[i-1][j]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lengthS][lengthT];
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "rabbbit",
                "babgbag",
        };
        String[] tSet = new String[]{
                "rabbit",
                "bag",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = numDistinctMy1(sSet[i], tSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numDistinct My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
