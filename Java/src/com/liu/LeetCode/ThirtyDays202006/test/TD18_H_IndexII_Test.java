package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD18_H_IndexII.hIndex;

/**
 * Created by Liu on 2020/6/18.
 */
public class TD18_H_IndexII_Test {
    public static void main(String[] args) {
        int[] citations;
        int result;
        long startTime;
        long endTime;


        citations = new int[]{
                0
        };
        startTime = System.currentTimeMillis();
        result = testMy1(citations);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_H_IndexII My 1 result: " + result + ", during time " + (endTime - startTime));

        citations = new int[]{
                100
        };
        startTime = System.currentTimeMillis();
        result = testMy1(citations);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_H_IndexII My 1 result: " + result + ", during time " + (endTime - startTime));

        citations = new int[]{
                3, 4, 5, 8, 10
        };
        startTime = System.currentTimeMillis();
        result = testMy1(citations);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_H_IndexII My 1 result: " + result + ", during time " + (endTime - startTime));

        citations = new int[]{
                3, 3, 5, 8, 10
        };
        startTime = System.currentTimeMillis();
        result = testMy1(citations);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_H_IndexII My 1 result: " + result + ", during time " + (endTime - startTime));

        citations = new int[]{
                0, 1, 3, 5, 6
        };
        startTime = System.currentTimeMillis();
        result = testMy1(citations);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_H_IndexII My 1 result: " + result + ", during time " + (endTime - startTime));

        citations = new int[]{
                0, 1, 2, 5, 6
        };
        startTime = System.currentTimeMillis();
        result = testMy1(citations);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_H_IndexII My 1 result: " + result + ", during time " + (endTime - startTime));

        citations = new int[]{
                0, 0, 2, 5, 6
        };
        startTime = System.currentTimeMillis();
        result = testMy1(citations);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_H_IndexII My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[] citations) {
        return hIndex(citations);
    }

}
