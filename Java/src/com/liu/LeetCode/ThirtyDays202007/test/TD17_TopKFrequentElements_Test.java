package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD17_TopKFrequentElements.topKFrequent;

/**
 * Created by Liu on 2020/7/18.
 */
public class TD17_TopKFrequentElements_Test {
    public static void main(String[] args) {
        int[] nums;
        int k;
        int[] result;
        long startTime;
        long endTime;


        nums = new int[]{
                1, 1, 1, 2, 2, 3
        };
        k = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_PowXN My 1 result size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        nums = new int[]{
                1
        };
        k = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_PowXN My 1 result size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static int[] testMy1(int[] nums, int k) {
        return topKFrequent(nums, k);
    }

}
