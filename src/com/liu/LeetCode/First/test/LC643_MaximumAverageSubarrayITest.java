package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC643_MaximumAverageSubarrayI.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC643_MaximumAverageSubarrayITest {

    public static void main(String[] args) {
        int[] nums = {
//                1, 12, -5, -6, 50, 3
                -1
        };
//        int k = 4;
        int k = 1;
        long startTime;
        double result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumAverageSubarrayI My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumAverageSubarrayI Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(int[] nums, int k) {
        return getMaximumAverageSubarrayIMy1(nums, k);
    }

    private static double testAnswer1(int[] nums, int k) {
        return getMaximumAverageSubarrayIAnswer1(nums, k);
    }
}
