package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC064_MinimumPathSum.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC064_MinimumPathSumTest {

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
        System.out.println("MinimumPathSum My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[][] nums) {
        return getMinimumPathSumMy1(nums);
    }
}
