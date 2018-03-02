package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC667_BeautifulArrangementII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC667_BeautifulArrangementIITest {

    public static void main(String[] args) {
        int num = 3;
        int k = 1;
        long startTime;
        int[] result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("BeautifulArrangementII My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("BeautifulArrangementII Answer 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] testMy1(int num, int k) {
        return getBeautifulArrangementIIMy1(num, k);
    }

    private static int[] testAnswer1(int num, int k) {
        return getBeautifulArrangementIIAnswer1(num, k);
    }
}
