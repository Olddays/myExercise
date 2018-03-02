package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC217_ContainsDuplicate.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC217_ContainsDuplicateTest {

    public static void main(String[] args) {
        int[] nums = {
                1, 2, 3
        };
        long startTime;
        boolean result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ContainsDuplicate My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(int[] nums) {
        return getContainsDuplicateMy1(nums);
    }
}
