package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD31_EditDistance.minDistance;

/**
 * Created by Liu on 2020/6/1.
 */
public class TD31_EditDistance_Test {
    public static void main(String[] args) {
        String word1;
        String word2;
        int result;
        long startTime;
        long endTime;

        word1 = "horse";
        word2 = "ros";
        startTime = System.currentTimeMillis();
        result = testMy1(word1, word2);
        endTime = System.currentTimeMillis();
        System.out.println("TD31_EditDistance My 1 result " + result + " during time " + (endTime - startTime));

        word1 = "intention";
        word2 = "execution";
        startTime = System.currentTimeMillis();
        result = testMy1(word1, word2);
        endTime = System.currentTimeMillis();
        System.out.println("TD31_EditDistance My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(String word1, String word2) {
        return minDistance(word1, word2);
    }

}
