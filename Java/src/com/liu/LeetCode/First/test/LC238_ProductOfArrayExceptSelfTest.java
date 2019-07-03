package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC238_ProductOfArrayExceptSelf.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC238_ProductOfArrayExceptSelfTest {

    public static void main(String[] args) {
        int[] nums = {
//                1
//                1, 2, 3
//                3, 2, 3
//                1, 2
                0, 4, 4
        };
        long startTime;
        int[] result;
        long endTime;

//        startTime = System.currentTimeMillis();
//        result = testMy1(nums);
//        endTime = System.currentTimeMillis();
//        System.out.println("ProductOfArrayExceptSelf My 1 result.length " + result.length + " during time " + (endTime - startTime));
//        for (int i : result) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ProductOfArrayExceptSelf My 2 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ProductOfArrayExceptSelf Answer 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] testMy1(int[] nums) {
        return getProductOfArrayExceptSelfMy1(nums);
    }

    private static int[] testMy2(int[] nums) {
        return getProductOfArrayExceptSelfMy2(nums);
    }

    private static int[] testAnswer1(int[] nums) {
        return getProductOfArrayExceptSelfAnswer1(nums);
    }
}
