package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD22_SubarraySumEqualsK.subarraySumMy1;
import static com.liu.LeetCode.ThirtyDays202004.exercise.TD22_SubarraySumEqualsK.subarraySumAnswer1;

/**
 * Created by Liu on 2020/4/22.
 */
public class TD22_SubarraySumEqualsK_Test {

    public static void main(String[] args) {
        int[] nums;
        int k;
        int result;
        long startTime;
        long endTime;


        nums = new int[]{28, 54, 7, -70, 22, 65, -6};
        k = 100;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK Answer 1 result " + result + " during time " + (endTime - startTime));


        nums = new int[]{1, 2, 3};
        k = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK Answer 1 result " + result + " during time " + (endTime - startTime));


        nums = new int[]{1, 1, 1};
        k = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_SubarraySumEqualsK Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int k) {
        return subarraySumMy1(nums, k);
    }

    private static int testAnswer1(int[] nums, int k) {
        return subarraySumAnswer1(nums, k);
    }
}
