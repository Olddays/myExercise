package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC581_ShortestUnsortedContinuousSubarray.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC581_ShortestUnsortedContinuousSubarrayTest {

    public static void main(String[] args) {
        int[] nums = {
                2, 6, 4, 8, 10, 9, 15
//                2, 1
//                5, 4, 3, 2, 1
//                1, 3, 2, 2, 2
//                1, 2, 3, 3, 3
//                1, 3, 5, 2, 4
//                2, 3, 1, 4, 5
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ShortestUnsortedContinuousSubarray My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ShortestUnsortedContinuousSubarray Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getShortestUnsortedContinuousSubarrayMy1(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getShortestUnsortedContinuousSubarrayAnswer1(nums);
    }
}
