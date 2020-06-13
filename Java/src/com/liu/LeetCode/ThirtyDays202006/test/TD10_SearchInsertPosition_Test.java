package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD10_SearchInsertPosition.searchInsert;

/**
 * Created by Liu on 2020/6/10.
 */
public class TD10_SearchInsertPosition_Test {
    public static void main(String[] args) {
        int[] nums;
        int target;
        int result;
        long startTime;
        long endTime;

        nums = new int[]{
                1, 3, 5, 6
        };
        target = 5;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_SearchInsertPosition My 1 result " + result + " during time " + (endTime - startTime));

        nums = new int[]{
                1, 3, 5, 6
        };
        target = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_SearchInsertPosition My 1 result " + result + " during time " + (endTime - startTime));

        nums = new int[]{
                1, 3, 5, 6
        };
        target = 7;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_SearchInsertPosition My 1 result " + result + " during time " + (endTime - startTime));

        nums = new int[]{
                1, 3, 5, 6
        };
        target = 0;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_SearchInsertPosition My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static int testMy1(int[] nums, int target) {
        return searchInsert(nums, target);
    }
}
