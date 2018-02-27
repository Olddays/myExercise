package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC719_Find_thSmallestPairDistance.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC719_Find_thSmallestPairDistanceTest {

    public static void main(String[] args) {
        int[] nums = {
//                1, 3, 1
                62, 100, 4
        };
//        int k = 1;
        int k = 2;
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("Find_thSmallestPairDistance My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("Find_thSmallestPairDistance Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(nums, k);
        endTime = System.currentTimeMillis();
        System.out.println("Find_thSmallestPairDistance Answer 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int k) {
        return getFind_thSmallestPairDistanceMy1(nums, k);
    }

    private static int testAnswer1(int[] nums, int k) {
        return getFind_thSmallestPairDistanceAnswer1(nums, k);
    }

    private static int testAnswer2(int[] nums, int k) {
        return getFind_thSmallestPairDistanceAnswer2(nums, k);
    }
}
