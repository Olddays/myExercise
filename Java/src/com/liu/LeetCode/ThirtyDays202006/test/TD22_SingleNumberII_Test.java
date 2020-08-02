package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD22_SingleNumberII.singleNumberAnswer1;
import static com.liu.LeetCode.ThirtyDays202006.exercise.TD22_SingleNumberII.singleNumberMy1;

/**
 * Created by Liu on 2020/6/22.
 */
public class TD22_SingleNumberII_Test {
    public static void main(String[] args) {
        int[] nums;
        int result;
        long startTime;
        long endTime;


        nums = new int[]{
                43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648, 43, 2147483647, -2147483646,
                -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646, -2147483647, 16, 16, 2147483646,
                43
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SingleNumberII My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                2, 2, 3, 2
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SingleNumberII My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                0, 1, 0, 1, 0, 1, 99
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SingleNumberII My 1 result: " + result + ", during time " + (endTime - startTime));


        nums = new int[]{
                43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648, 43, 2147483647, -2147483646,
                -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646, -2147483647, 16, 16, 2147483646,
                43
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SingleNumberII Answer 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                2, 2, 3, 2
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SingleNumberII Answer 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                0, 1, 0, 1, 0, 1, 99
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SingleNumberII Answer 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return singleNumberMy1(nums);
    }

    private static int testAnswer1(int[] nums) {
        return singleNumberAnswer1(nums);
    }

}
