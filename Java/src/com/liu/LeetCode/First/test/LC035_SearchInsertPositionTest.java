package com.liu.LeetCode.First.test;


import static com.liu.LeetCode.First.exercise.LC035_SearchInsertPosition.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC035_SearchInsertPositionTest {

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 8, 10};
//        int[] nums = new int[]{8};
        int[] nums = new int[]{6, 7};
        int target = 8;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("SearchInsertPosition My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("SearchInsertPosition My 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int target) {
        return getSearchInsertPositionMy1(nums, target);
    }
    private static int testMy2(int[] nums, int target) {
        return getSearchInsertPositionMy2(nums, target);
    }
}
