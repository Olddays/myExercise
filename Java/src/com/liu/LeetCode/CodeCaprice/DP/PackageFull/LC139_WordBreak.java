package com.liu.LeetCode.CodeCaprice.DP.PackageFull;

import java.util.*;

public class LC139_WordBreak {
    // Beats 24.85%
    private static boolean wordBreakMy1(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1]; // dp[i]表示前i个字符是否可以被wordDict中的单词组成
        dp[0] = true; // dp[0]表示空字符串可以被组成，所以是true
        // 递推公式，dp[i] = dp[j] && set.contains(s.substring(j, i))
        // dp[j]是true，同时i和j中间的子串在wordDict中
        // 遍历顺序是求排列，所以先背包后物品，因为word的组合是有序的
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) { // 截取操作，截取来进行判断
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // 得到true后，二层for就不用继续了，可以减少一些遍历时间的浪费
                }
            }
        }
        return dp[length];
    }

    // Beats 44.37%
    private static boolean wordBreakMy2(String s, List<String> wordDict) {
        int length = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[length + 1]; // dp[i]表示前i个字符是否可以被wordDict中的单词组成
        dp[0] = true; // dp[0]表示空字符串可以被组成，所以是true
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "leetcode",
                "applepenapple",
                "catsandog",
        };
        String[][] wordDictSet = new String[][]{
                {"leet", "code"},
                {"apple", "pen"},
                {"cats", "dog", "sand", "and", "cat"},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = wordBreakMy1(sSet[i], Arrays.asList(wordDictSet[i]));
            endTime = System.currentTimeMillis();
            System.out.println("wordBreak My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = wordBreakMy2(sSet[i], Arrays.asList(wordDictSet[i]));
            endTime = System.currentTimeMillis();
            System.out.println("wordBreak My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
