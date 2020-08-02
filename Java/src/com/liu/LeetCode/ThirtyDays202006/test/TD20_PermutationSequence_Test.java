package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD20_PermutationSequence.getPermutation;

/**
 * Created by Liu on 2020/6/22.
 */
public class TD20_PermutationSequence_Test {
    public static void main(String[] args) {
        int n;
        int k;
        String result;
        long startTime;
        long endTime;


        n = 3;
        k = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(n, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD19_LongestDuplicateSubstring My 1 result: " + result + ", during time " + (endTime - startTime));

        n = 4;
        k = 9;
        startTime = System.currentTimeMillis();
        result = testMy1(n, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD19_LongestDuplicateSubstring My 1 result: " + result + ", during time " + (endTime - startTime));

    }

    private static String testMy1(int n, int k) {
        return getPermutation(n, k);
    }

}
