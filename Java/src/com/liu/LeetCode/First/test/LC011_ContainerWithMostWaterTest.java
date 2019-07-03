package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC011_ContainerWithMostWater.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC011_ContainerWithMostWaterTest {



    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 1};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums1);
        endTime = System.currentTimeMillis();
        System.out.println("ContainerWithMostWater My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums1);
        endTime = System.currentTimeMillis();
        System.out.println("ContainerWithMostWater Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums1) {
        return getContainerWithMostWaterMy1(nums1);
    }

    private static int testAnswer1(int[] nums1) {
        return getContainerWithMostWaterAnswer1(nums1);
    }
}
