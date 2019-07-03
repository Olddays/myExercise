package com.liu.LeetCode.First.test;


import java.util.List;

import static com.liu.LeetCode.First.exercise.LC039_CombinationSum.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC039_CombinationSumTest {

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3 ,6, 7};
//        int target = 7;
//        int[] nums = new int[]{2, 3, 5};
//        int target = 7;
//        int[] nums = new int[]{1, 2, 3, 5};
//        int target = 7;
//        int[] nums = new int[]{1};
//        int target = 2;
        int[] nums = new int[]{1, 2};
        int target = 3;
        List<List<Integer>> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("CombinationSum My 1 result length " + result.size() + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.println("CombinationSum My 1 result " + i + " during time " + (endTime - startTime));
            }
            System.out.println();
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy2(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("CombinationSum My 2 result length " + result.size() + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.println("CombinationSum My 2 result " + i + " during time " + (endTime - startTime));
            }
            System.out.println();
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy3(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("CombinationSum My 3 result length " + result.size() + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.println("CombinationSum My 3 result " + i + " during time " + (endTime - startTime));
            }
            System.out.println();
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("CombinationSum Answer 4 result length " + result.size() + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.println("CombinationSum Answer 4 result " + i + " during time " + (endTime - startTime));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<List<Integer>> testMy1(int[] nums, int target) {
        return getCombinationSumMy1(nums, target);
    }

    private static List<List<Integer>> testMy2(int[] nums, int target) {
        return getCombinationSumMy2(nums, target);
    }

    private static List<List<Integer>> testMy3(int[] nums, int target) {
        return getCombinationSumMy3(nums, target);
    }

    private static List<List<Integer>> testAnswer1(int[] nums, int target) {
        return getCombinationSumAnswer1(nums, target);
    }
}
