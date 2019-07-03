package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC605_CanPlaceFlowers.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC605_CanPlaceFlowersTest {

    public static void main(String[] args) {
        int[] nums = {
                1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0
        };
        int n = 2;
        long startTime;
        boolean result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, n);
        endTime = System.currentTimeMillis();
        System.out.println("CanPlaceFlowers My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, n);
        endTime = System.currentTimeMillis();
        System.out.println("CanPlaceFlowers Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(int[] flowerbed, int n) {
        return getCanPlaceFlowersMy1(flowerbed, n);
    }

    private static boolean testAnswer1(int[] flowerbed, int n) {
        return getCanPlaceFlowersAnswer1(flowerbed, n);
    }
}
