package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC268_MissingNumber.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC268_MissingNumberTest {

    public static void main(String[] args) {
        int[] nums = {
                0, 1, 3
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MissingNumber My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MissingNumber Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MissingNumber Answer 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer3(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MissingNumber Answer 3 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getMissingNumberMy1(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getMissingNumberAnswer1(nums);
    }

    private static int testAnswer2(int[] nums) {
        return getMissingNumberAnswer2(nums);
    }

    private static int testAnswer3(int[] nums) {
        return getMissingNumberAnswer3(nums);
    }
}
