package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC287_FindTheDuplicateNumber.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC287_FindTheDuplicateNumberTest {

    public static void main(String[] args) {
        int[] nums = {
//                1, 2, 3, 4, 5, 6, 7, 7
//                2, 2, 2, 2, 2
                2, 5, 1, 1, 4, 3
        };
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FindTheDuplicateNumber My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FindTheDuplicateNumber Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FindTheDuplicateNumber Answer 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer3(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FindTheDuplicateNumber Answer 3 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getFindTheDuplicateNumberMy1(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getFindTheDuplicateNumberAnswer1(nums);
    }

    private static int testAnswer2(int[] nums) {
        return getFindTheDuplicateNumberAnswer2(nums);
    }

    private static int testAnswer3(int[] nums) {
        return getFindTheDuplicateNumberAnswer3(nums);
    }
}
