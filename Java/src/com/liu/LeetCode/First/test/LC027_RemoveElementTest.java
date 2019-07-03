package com.liu.LeetCode.First.test;


import static com.liu.LeetCode.First.exercise.LC027_RemoveElement.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC027_RemoveElementTest {

    public static void main(String[] args) {
//        int[] nums = new int[]{1}; // 注意边界情况
//        int val = 1; // 注意边界情况
//        int[] nums = new int[]{3, 2, 2, 3};
//        int val = 3;
//        int[] nums = new int[]{2, 2, 3};
//        int val = 2;
//        int[] nums = new int[]{1, 2, 3, 4};
//        int val = 1;
//        int[] nums = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
//        int val = 4;
        int[] nums = new int[]{4, 2, 0, 2, 2, 1, 4, 4, 1, 4, 3, 2};
        int val = 4;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, val);
        endTime = System.currentTimeMillis();
        System.out.println("RemoveElement My 1 result " + result + " during time " + (endTime - startTime));

//        nums = new int[]{2, 2, 3}; // 注意 每次计算结束 nums的数据会被更改
//        nums = new int[]{3, 2, 2, 3};
//        nums = new int[]{1, 2, 3, 4};
//        nums = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
        nums = new int[]{4, 2, 0, 2, 2, 1, 4, 4, 1, 4, 3, 2};
        startTime = System.currentTimeMillis();
        result = testMy2(nums, val);
        endTime = System.currentTimeMillis();
        System.out.println("RemoveElement My 2 result " + result + " during time " + (endTime - startTime));

//        nums = new int[]{2, 2, 3}; // 注意 每次计算结束 nums的数据会被更改
//        nums = new int[]{3, 2, 2, 3};
//        nums = new int[]{1, 2, 3, 4};
//        nums = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
        nums = new int[]{4, 2, 0, 2, 2, 1, 4, 4, 1, 4, 3, 2};
        startTime = System.currentTimeMillis();
        result = testMy3(nums, val);
        endTime = System.currentTimeMillis();
        System.out.println("RemoveElement My 3 result " + result + " during time " + (endTime - startTime));

//        nums = new int[]{2, 2, 3}; // 注意 每次计算结束 nums的数据会被更改
//        nums = new int[]{3, 2, 2, 3};
//        nums = new int[]{1, 2, 3, 4};
        nums = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
        nums = new int[]{4, 2, 0, 2, 2, 1, 4, 4, 1, 4, 3, 2};
        startTime = System.currentTimeMillis();
        result = testMy4(nums, val);
        endTime = System.currentTimeMillis();
        System.out.println("RemoveElement My 4 result " + result + " during time " + (endTime - startTime));

//        nums = new int[]{2, 2, 3};
//        nums = new int[]{3, 2, 2, 3};
//        nums = new int[]{1, 2, 3, 4};
        nums = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
        nums = new int[]{4, 2, 0, 2, 2, 1, 4, 4, 1, 4, 3, 2};
        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, val);
        endTime = System.currentTimeMillis();
        System.out.println("RemoveElement Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int val) {
        return getRemoveElementMy1(nums, val);
    }

    private static int testMy2(int[] nums, int val) {
        return getRemoveElementMy2(nums, val);
    }

    private static int testMy3(int[] nums, int val) {
        return getRemoveElementMy3(nums, val);
    }

    private static int testMy4(int[] nums, int val) {
        return getRemoveElementMy4(nums, val);
    }

    private static int testAnswer1(int[] nums, int val) {
        return getRemoveElementAnswer1(nums, val);
    }

}
