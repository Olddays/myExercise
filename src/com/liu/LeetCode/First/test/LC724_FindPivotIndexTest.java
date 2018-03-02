package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC724_FindPivotIndex.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC724_FindPivotIndexTest {

    public static void main(String[] args) {
        int[] nums = {
                1, 7, 3, 6, 5, 6
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FindPivotIndex My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FindPivotIndex Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getFindPivotIndexMy1(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getFindPivotIndexAnswer1(nums);
    }
}
