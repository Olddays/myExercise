package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC076_MinimumWindowSubstring.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC076_MinimumWindowSubstringTest {

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        String s = "a";
//        String t = "aa";
        String s = "ab";
        String t = "a";
        long startTime;
        String result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(s, t);
        endTime = System.currentTimeMillis();
        System.out.println("MinimumWindowSubstring Answer 1 " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(s, t);
        endTime = System.currentTimeMillis();
        System.out.println("MinimumWindowSubstring Answer 2 " + result + " during time " + (endTime - startTime));
    }

    private static String testAnswer1(String s, String t) {
        return getMinimumWindowSubstringAnswer1(s, t);
    }

    private static String testAnswer2(String s, String t) {
        return getMinimumWindowSubstringAnswer2(s, t);
    }
}
