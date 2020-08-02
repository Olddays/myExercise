package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD15_ReverseWordsInAString.reverseWordsMy1;
import static com.liu.LeetCode.ThirtyDays202007.exercise.TD15_ReverseWordsInAString.reverseWordsMy2;

/**
 * Created by Liu on 2020/7/15.
 */
public class TD15_ReverseWordsInAString_Test {

    public static void main(String[] args) {
        String s;
        String result;
        long startTime;
        long endTime;


        s = " ";
        startTime = System.currentTimeMillis();
        result = testMy1(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 1 result: " + result + ", during time " + (endTime - startTime));

        s = "a good   example";
        startTime = System.currentTimeMillis();
        result = testMy1(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 1 result: " + result + ", during time " + (endTime - startTime));

        s = "";
        startTime = System.currentTimeMillis();
        result = testMy1(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 1 result: " + result + ", during time " + (endTime - startTime));

        s = "the sky is blue";
        startTime = System.currentTimeMillis();
        result = testMy1(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 1 result: " + result + ", during time " + (endTime - startTime));

        s = "  hello world!  ";
        startTime = System.currentTimeMillis();
        result = testMy1(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 1 result: " + result + ", during time " + (endTime - startTime));


        s = " ";
        startTime = System.currentTimeMillis();
        result = testMy2(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 2 result: " + result + ", during time " + (endTime - startTime));

        s = "a good   example";
        startTime = System.currentTimeMillis();
        result = testMy2(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 2 result: " + result + ", during time " + (endTime - startTime));

        s = "";
        startTime = System.currentTimeMillis();
        result = testMy2(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 2 result: " + result + ", during time " + (endTime - startTime));

        s = "the sky is blue";
        startTime = System.currentTimeMillis();
        result = testMy2(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 2 result: " + result + ", during time " + (endTime - startTime));

        s = "  hello world!  ";
        startTime = System.currentTimeMillis();
        result = testMy2(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_ReverseWordsInAString My 2 result: " + result + ", during time " + (endTime - startTime));
    }

    private static String testMy1(String s) {
        return reverseWordsMy1(s);
    }

    private static String testMy2(String s) {
        return reverseWordsMy2(s);
    }
}
