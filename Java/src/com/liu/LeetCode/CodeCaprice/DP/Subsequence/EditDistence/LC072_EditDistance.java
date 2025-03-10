package com.liu.LeetCode.CodeCaprice.DP.Subsequence.EditDistence;

public class LC072_EditDistance {

    // Beats 64.56%
    private static int minDistanceMy1(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        // dp[i][j] 表示word1[0:i]和word2[0:j]的变化的数量
        int[][] dp = new int[length1 + 1][length2 + 1];
        // 初始化dp[i][0]和dp[0][j]
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
                    dp[i][j] = dp[i - 1][j - 1]; // 如果相等，无需变化
                } else {
                    // 有三种变化方式，分别是替换，删除和增加
                    // 达到你是增加和删除可以改为：删除word1的字符，删除word2的字符
                    // 所以可以合并为：删除word1的字符，删除word2的字符，替换word1的字符
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String[] word1Set = new String[]{
                "horse",
                "intention",
        };
        String[] word2Set = new String[]{
                "ros",
                "execution",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < word1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = minDistanceMy1(word1Set[i], word2Set[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minDistance My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
