package com.liu.LeetCode.First.test;


import static com.liu.LeetCode.First.exercise.LC031_NextPermutation.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC031_NextPermutationTest {

    // https://yq.aliyun.com/articles/863

    public static void main(String[] args) {
        int[] nums = new int[]{6, 5, 4, 8, 7, 5, 1};
//        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{1, 2};
//        int[] nums = new int[]{1, 4, 3, 2};
//        int[] nums = new int[]{5, 4, 7, 5, 3, 2};
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("NextPermutation My 1 during time " + (endTime - startTime));

        nums = new int[]{6, 5, 4, 8, 7, 5, 1};
//        nums = new int[]{1, 2, 3};
//        nums = new int[]{1, 2};
//        nums = new int[]{1, 4, 3, 2};
//        nums = new int[]{5, 4, 7, 5, 3, 2};
        startTime = System.currentTimeMillis();
        testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("NextPermutation My 2 during time " + (endTime - startTime));

        nums = new int[]{6, 5, 4, 8, 7, 5, 1};
//        nums = new int[]{1, 2, 3};
//        nums = new int[]{1, 2};
//        nums = new int[]{1, 4, 3, 2};
//        nums = new int[]{5, 4, 7, 5, 3, 2};
        startTime = System.currentTimeMillis();
        testMy3(nums);
        endTime = System.currentTimeMillis();
        System.out.println("NextPermutation My 3 during time " + (endTime - startTime));

        nums = new int[]{6, 5, 4, 8, 7, 5, 1};
//        nums = new int[]{1, 2, 3};
//        nums = new int[]{1, 2};
//        nums = new int[]{1, 4, 3, 2};
//        nums = new int[]{5, 4, 7, 5, 3, 2};
        startTime = System.currentTimeMillis();
        testMy4(nums);
        endTime = System.currentTimeMillis();
        System.out.println("NextPermutation My 4 during time " + (endTime - startTime));
    }

    private static void testMy1(int[] nums) {
        getNextPermutationMy1(nums);
    }

    private static void testMy2(int[] nums) {
        getNextPermutationMy2(nums);
    }

    private static void testMy3(int[] nums) {
        getNextPermutationMy3(nums);
    }

    private static void testMy4(int[] nums) {
        getNextPermutationMy4(nums);
    }
}
