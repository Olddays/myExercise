package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC532_K_DiffPairsInAnArray.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC532_K_DiffPairsInAnArrayTest {

    public static void main(String[] args) {
        int[] nums = {
//                3, 1, 4, 1, 5
//                1, 2, 3, 4, 5
//                1, 1, 1, 1, 1
                1, 1, 1, 2, 2
        };
//        int input = 2;
//        int input = 0;
        int input = 1;
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, input);
        endTime = System.currentTimeMillis();
        System.out.println("K_DiffPairsInAnArray My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums, input);
        endTime = System.currentTimeMillis();
        System.out.println("K_DiffPairsInAnArray My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(nums, input);
        endTime = System.currentTimeMillis();
        System.out.println("K_DiffPairsInAnArray My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums, input);
        endTime = System.currentTimeMillis();
        System.out.println("K_DiffPairsInAnArray Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int k) {
        return getK_DiffPairsInAnArrayMy1(nums, k);
    }

    private static int testMy2(int[] nums, int k) {
        return getK_DiffPairsInAnArrayMy2(nums, k);
    }

    private static int testMy3(int[] nums, int k) {
        return getK_DiffPairsInAnArrayMy3(nums, k);
    }

    private static int testAnswer1(int[] nums, int k) {
        return getK_DiffPairsInAnArrayAnswer1(nums, k);
    }
}
