package com.liu.LeetCode.ThirtyDays202004.exercise;

/**
 * Created by Liu on 2020/4/26.
 */
public class TD26_LongestCommonSubsequence {
    public static int longestCommonSubsequenceMy1(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        if (length1 == 0 || length2 == 0) {
            return 0;
        }
        char[] chars;
        String preCheck;
        if (length1 < length2) {
            chars = text1.toCharArray();
            preCheck = text2;
        } else {
            chars = text2.toCharArray();
            preCheck = text1;
        }
        int max = 0;
        int cache = 0;
        int count = 0;
        for (char c : chars) {
            if (preCheck.contains(String.valueOf(c))) {
                int i = preCheck.indexOf(c);
                if (i < cache) {
                    max = Math.max(max, count);
                    count = 1;
                } else {
                    count++;
                }
                cache = i;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    public static int longestCommonSubsequenceMy2(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        if (length1 == 0 || length2 == 0) {
            return 0;
        }
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] DP = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1; i++) {
            char c1 = chars1[i];
            for (char j = 0; j < length2; j++) {
                char c2 = chars2[j];
                if (c1 == c2) {
                    DP[i + 1][j + 1] = DP[i][j] + 1;
                } else {
                    DP[i + 1][j + 1] = Math.max(DP[i][j + 1], DP[i + 1][j]);
                }
            }
        }
        return DP[length1][length2];
    }
}
