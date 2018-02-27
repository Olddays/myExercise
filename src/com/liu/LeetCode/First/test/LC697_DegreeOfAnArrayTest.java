package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC697_DegreeOfAnArray.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC697_DegreeOfAnArrayTest {

    public static void main(String[] args) {
        int[] nums = {
//                1, 2, 2, 3, 1, 4, 2
                1, 2, 2, 3, 1
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("DegreeOfAnArray My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("DegreeOfAnArray My 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getDegreeOfAnArrayMy1(nums);
    }

    private static int testMy2(int[] nums) {
        return getDegreeOfAnArrayMy2(nums);
    }
}
