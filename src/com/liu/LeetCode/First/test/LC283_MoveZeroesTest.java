package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC283_MoveZeroes.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC283_MoveZeroesTest {

    public static void main(String[] args) {
        int[] nums = {
//                1, 3, 12, 0, 0
                0, 1, 0, 3, 12
        };
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MoveZeroes My 1 during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MoveZeroes Answer 1 during time " + (endTime - startTime));
    }

    private static void testMy1(int[] nums) {
        getMoveZeroesMy1(nums);
    }

    private static void testAnswer1(int[] nums) {
        getMoveZeroesAnswer1(nums);
    }
}
