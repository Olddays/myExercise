package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC063_UniquePathsII.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC063_UniquePathsIITest {


    public static void main(String[] args) {
        int[][] nums = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0},
//                {0, 0},
//                {1, 1},
                {0, 0},
        };
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("UniquePathsII My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("UniquePathsII My 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[][] nums) {
        return getUniquePathsIIMy1(nums);
    }

    private static int testMy2(int[][] nums) {
        return getUniquePathsIIMy2(nums);
    }
}
