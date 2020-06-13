package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD18_PermutationInString.checkInclusion;

/**
 * Created by Liu on 2020/5/19.
 */
public class TD18_PermutationInString_Test {
    public static void main(String[] args) {
        String s1;
        String s2;
        boolean result;
        long startTime;
        long endTime;

        s1 = "ab";
        s2 = "eidbaooo";
        startTime = System.currentTimeMillis();
        result = testMy1(s1, s2);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_PermutationInString My 1 result " + result + " during time " + (endTime - startTime));

        s1 = "ab";
        s2 = "eidbaooo";
        startTime = System.currentTimeMillis();
        result = testMy1(s1, s2);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_PermutationInString My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(String s1, String s2) {
        return checkInclusion(s1, s2);
    }

}
