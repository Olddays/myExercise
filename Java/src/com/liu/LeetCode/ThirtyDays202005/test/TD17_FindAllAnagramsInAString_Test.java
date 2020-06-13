package com.liu.LeetCode.ThirtyDays202005.test;

import java.util.List;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD17_FindAllAnagramsInAString.findAnagrams;

/**
 * Created by Liu on 2020/5/19.
 */
public class TD17_FindAllAnagramsInAString_Test {
    public static void main(String[] args) {
        String s;
        String p;
        List<Integer> result;
        long startTime;
        long endTime;

        s = "cbaebabacd";
        p = "abc";
        startTime = System.currentTimeMillis();
        result = testMy1(s, p);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_FindAllAnagramsInAString My 1 result.size " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        s = "abab";
        p = "ab";
        startTime = System.currentTimeMillis();
        result = testMy1(s, p);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_FindAllAnagramsInAString My 1 result.size " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> testMy1(String s, String p) {
        return findAnagrams(s, p);
    }

}
