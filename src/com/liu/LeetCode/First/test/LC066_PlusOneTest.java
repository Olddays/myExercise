package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC066_PlusOne.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC066_PlusOneTest {

    public static void main(String[] args) {
        int[] nums = new int[]{
                9, 9
        };
        int[] result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("PlusOne My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("PlusOne Answer 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] testMy1(int[] nums) {
        return getPlusOneMy1(nums);
    }

    private static int[] testAnswer1(int[] nums) {
        return getPlusOneAnswer1(nums);
    }
}
