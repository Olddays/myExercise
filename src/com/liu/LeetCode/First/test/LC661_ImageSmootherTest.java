package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC661_ImageSmoother.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC661_ImageSmootherTest {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        long startTime;
        int[][] result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ImageSmoother My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int[] line : result) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ImageSmoother Answer 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int[] line : result) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[][] testMy1(int[][] nums) {
        return getImageSmootherMy1(nums);
    }

    private static int[][] testAnswer1(int[][] nums) {
        return getImageSmootherAnswer1(nums);
    }
}
