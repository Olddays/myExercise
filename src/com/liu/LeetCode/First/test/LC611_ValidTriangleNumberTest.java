package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC611_ValidTriangleNumber.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC611_ValidTriangleNumberTest {

    public static void main(String[] args) {
        int[] nums = {
//                2, 2, 3, 4
//                0, 1, 0
                24, 3, 82, 22, 35, 84, 19
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ValidTriangleNumber My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ValidTriangleNumber Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getValidTriangleNumberMy1(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getValidTriangleNumberAnswer1(nums);
    }
}
