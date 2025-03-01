package com.liu.LeetCode.Daily.Daily202502;

public class LC1092_ShortestCommonSupersequence {

    // 俺寻思得用KMP，总之第一步找到最长相同子串，然后三段拼起来
    // Beats 64.51%
    private static String shortestCommonSupersequenceMy1(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder longestCommonSubsequenceBuilder = new StringBuilder();
        int i = length1;
        int j = length2;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                longestCommonSubsequenceBuilder.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        String longestCommonSubsequence = longestCommonSubsequenceBuilder.reverse().toString();
        int index1 = 0;
        int index2 = 0;
        StringBuilder resultBuilder = new StringBuilder();
        for (char c : longestCommonSubsequence.toCharArray()) {
            while (str1.charAt(index1) != c) {
                resultBuilder.append(str1.charAt(index1));
                index1++;
            }
            while (str2.charAt(index2) != c) {
                resultBuilder.append(str2.charAt(index2));
                index2++;
            }
            resultBuilder.append(c);
            index1++;
            index2++;
        }
        // index不一定会等于str的长度，所以要把最后的部分再拼上
        resultBuilder.append(str1.substring(index1));
        resultBuilder.append(str2.substring(index2));
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        String[] str1List = new String[]{
                "abac",
                "aaaaaaaa",
        };
        String[] str2List = new String[]{
                "cab",
                "aaaaaaaa",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < str1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = shortestCommonSupersequenceMy1(str1List[i], str2List[i]);
            endTime = System.currentTimeMillis();
            System.out.println("shortestCommonSupersequence My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
