package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD26_LongestCommonSubsequence.longestCommonSubsequenceMy1;
import static com.liu.LeetCode.ThirtyDays202004.exercise.TD26_LongestCommonSubsequence.longestCommonSubsequenceMy2;

/**
 * Created by Liu on 2020/4/26.
 */
public class TD26_LongestCommonSubsequence_Test {

    public static void main(String[] args) {
        String text1;
        String text2;
        int result;
        long startTime;
        long endTime;


        text1 = "hofubmnylkra";
        text2 = "pqhgxgdofcvmr";
        startTime = System.currentTimeMillis();
        result = testMy1(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 2 result " + result + " during time " + (endTime - startTime));


        text1 = "oxcpqrsvwf";
        text2 = "shmtulqrypy";
        startTime = System.currentTimeMillis();
        result = testMy1(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 2 result " + result + " during time " + (endTime - startTime));


        text1 = "abcde";
        text2 = "ace";
        startTime = System.currentTimeMillis();
        result = testMy1(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 2 result " + result + " during time " + (endTime - startTime));


        text1 = "abc";
        text2 = "abc";
        startTime = System.currentTimeMillis();
        result = testMy1(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 2 result " + result + " during time " + (endTime - startTime));


        text1 = "abc";
        text2 = "def";
        startTime = System.currentTimeMillis();
        result = testMy1(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(text1, text2);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(String text1, String text2) {
        return longestCommonSubsequenceMy1(text1, text2);
    }

    private static int testMy2(String text1, String text2) {
        return longestCommonSubsequenceMy2(text1, text2);
    }
}
