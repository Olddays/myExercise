package com.liu.LeetCode.ThirtyDays202006.test;

import java.util.List;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD13_LargestDivisibleSubset.largestDivisibleSubset;

/**
 * Created by Liu on 2020/7/1.
 */
public class TD13_LargestDivisibleSubset_Test {
    public static void main(String[] args) {
        int[] nums;
        List<Integer> result;
        long startTime;
        long endTime;


        nums = new int[]{
                1, 2, 3
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_LargestDivisibleSubset My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                1, 2, 4, 8
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_LargestDivisibleSubset My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static List<Integer> testMy1(int[] nums) {
        return largestDivisibleSubset(nums);
    }

}
