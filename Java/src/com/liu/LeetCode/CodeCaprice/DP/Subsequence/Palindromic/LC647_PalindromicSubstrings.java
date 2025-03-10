package com.liu.LeetCode.CodeCaprice.DP.Subsequence.Palindromic;

public class LC647_PalindromicSubstrings {

    // dp
    // Beats 40.13%
    private static int countSubstringsMy1(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        int count = 0;
        // dp[i][j] 表示s[i:j]是否为回文子串
        // 如果是回文，那么拓展中间为中心的字符串，即s[i-1]和s[j+1]
        // 如果s[i-1]和s[j+1]相等，那么s[i-1:j+1]也是回文子串
        // 如果s[i-1]和s[j+1]不相等，那么s[i-1:j+1]不是回文子串
        // 也就是从中间往两边遍历查找
        boolean[][] dp = new boolean[length][length];
        // 初始化，每一个具体的字母都是一个回文串，可以不做，可以放在递推公式里面进行
        // for (int i = 0; i < length; i++) {
        //     dp[i][i] = true;
        //     count++;
        // }
        // 从中间往两边遍历查找
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                if (i == j) { // 一个字母，那就是回文子串，也可以在初始化种进行
                    dp[i][j] = true;
                    count++;
                } else if (j - i == 1) { // 两个字母，如果字母一致，那就是回文子串
                    dp[i][j] = true;
                    count++;
                } else { // 此时i-j>=2，此时需要判断s[i]和s[j]是否一致
                    // 然后判断s[i+1:j-1]是否为回文子串，因为i<=j，所以查看二者中间，就是i+1和j-1
                    if (dp[i + 1][j - 1]) { // i+1和j-1说明从左下角开始，那么i就得从右往左遍历
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // double point
    // Beats 96.79%
    private static int countSubstringsMy2(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            count += extend(s, i, i, length);// 以i为中心
            count += extend(s, i, i + 1, length);// 以i和i+1为中心
        }
        return count;
    }

    private static int extend(String s, int i, int j, int length) {
        int result = 0;
        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "abc",
                "aaa",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = countSubstringsMy1(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countSubstrings My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = countSubstringsMy2(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countSubstrings My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
