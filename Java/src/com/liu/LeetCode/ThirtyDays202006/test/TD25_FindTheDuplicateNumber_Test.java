package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD25_FindTheDuplicateNumber.findDuplicate;

/**
 * Created by Liu on 2020/6/27.
 */
public class TD25_FindTheDuplicateNumber_Test {
    public static void main(String[] args) {
        int[] nums;
        int result;
        long startTime;
        long endTime;

        nums = new int[]{
                1, 3, 4, 2, 2
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD25_FindTheDuplicateNumber My 1 result " + result + " during time " + (endTime - startTime));

        nums = new int[]{
                3, 1, 3, 4, 2
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD25_FindTheDuplicateNumber My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return findDuplicate(nums);
    }

}
