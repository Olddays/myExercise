package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC075_SortColors.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC075_SortColorsTest {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 0, 1, 1, 1, 2, 2, 0, 0, 2, 1, 0
        };
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        // 无法处理,注释掉
//        testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SortColors My 1 during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SortColors My 2 during time " + (endTime - startTime));
    }

    private static void testMy1(int[] nums) {
        getSortColorsMy1(nums);
    }

    private static void testMy2(int[] nums) {
        getSortColorsMy2(nums);
    }
}
