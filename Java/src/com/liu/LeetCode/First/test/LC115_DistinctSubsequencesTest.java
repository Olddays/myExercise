package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC115_DistinctSubsequences.numDistinct;

/**
 * Created by Liu on 2020/7/22.
 */
public class LC115_DistinctSubsequencesTest {
    public static void main(String[] args) {
        String s;
        String t;
        int result;
        long startTime;
        long endTime;


        s = "rabbbit";
        t = "rabbit";
        startTime = System.currentTimeMillis();
        result = testMy1(s, t);
        endTime = System.currentTimeMillis();
        System.out.println("LC115_DistinctSubsequences My 1 result: " + result + ", during time " + (endTime - startTime));

        s = "babgbag";
        t = "bag";
        startTime = System.currentTimeMillis();
        result = testMy1(s, t);
        endTime = System.currentTimeMillis();
        System.out.println("LC115_DistinctSubsequences My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(String s, String t) {
        return numDistinct(s, t);
    }
}
