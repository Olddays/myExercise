package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC689_MaximumSumOf3Non_OverlappingSubarrays.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC689_MaximumSumOf3Non_OverlappingSubarraysTest {

    public static void main(String[] args) {
        int[] nums = {
                1, 2, 1, 2, 6, 7, 5, 1
//                7, 13, 20, 19, 19, 2, 10, 1, 1, 19
        };
//        int k = 2;
        int k = 3;
        long startTime;
        int[] result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSumOf3Non_OverlappingSubarrays My 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy2(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSumOf3Non_OverlappingSubarrays My 2 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumSumOf3Non_OverlappingSubarrays Answer 1 result.length " + result.length + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] testMy1(int[] nums, int k) {
        return getMaximumSumOf3Non_OverlappingSubarraysMy1(nums, k);
    }

    private static int[] testMy2(int[] nums, int k) {
        return getMaximumSumOf3Non_OverlappingSubarraysMy2(nums, k);
    }

    private static int[] testAnswer1(int[] nums, int k) {
        return getMaximumSumOf3Non_OverlappingSubarraysAnswer1(nums, k);
    }
}
