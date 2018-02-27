package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC218_ContainsDuplicateII.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC218_ContainsDuplicateIITest {

    public static void main(String[] args) {
        int[] nums = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 9
        };
        int k = 3;
        long startTime;
        boolean result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("ContainsDuplicateII My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("ContainsDuplicateII My 2 result " + result + " during time " + (endTime - startTime));
    }

    // 可能会由于k>=nums.length出现数组越界
    private static boolean testMy1(int[] nums, int k) {
//        return getContainsDuplicateIIMy1(nums, k);
        return false;
    }

    private static boolean testMy2(int[] nums, int k) {
        return getContainsDuplicateIIMy2(nums, k);
    }
}
