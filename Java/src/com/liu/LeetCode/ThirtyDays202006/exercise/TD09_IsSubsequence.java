package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/9.
 */
public class TD09_IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n < m) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (tChars[j] == sChars[i]) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}
