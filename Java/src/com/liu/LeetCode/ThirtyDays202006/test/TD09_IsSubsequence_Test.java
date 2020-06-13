package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD09_IsSubsequence.isSubsequence;

/**
 * Created by Liu on 2020/6/9.
 */
public class TD09_IsSubsequence_Test {
    public static void main(String[] args) {
        String s;
        String t;
        boolean result;
        long startTime;
        long endTime;

        s = "ace";
        t = "abcde";
        startTime = System.currentTimeMillis();
        result = testMy1(s, t);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_IsSubsequence My 1 result " + result + " during time " + (endTime - startTime));

        s = "aec";
        t = "abcde";
        startTime = System.currentTimeMillis();
        result = testMy1(s, t);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_IsSubsequence My 1 result " + result + " during time " + (endTime - startTime));

        s = "axc";
        t = "ahbgdc";
        startTime = System.currentTimeMillis();
        result = testMy1(s, t);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_IsSubsequence My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static boolean testMy1(String s, String t) {
        return isSubsequence(s, t);
    }
}
