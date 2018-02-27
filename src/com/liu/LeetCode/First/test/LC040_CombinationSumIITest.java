package com.liu.LeetCode.First.test;


import java.util.List;

import static com.liu.LeetCode.First.exercise.LC040_CombinationSumII.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC040_CombinationSumIITest {

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3 ,6, 7};
//        int target = 7;
//        int[] nums = new int[]{2, 3, 5};
//        int target = 7;
//        int[] nums = new int[]{1, 2, 3, 5};
//        int target = 7;
//        int[] nums = new int[]{1};
//        int target = 2;
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("CombinationSumII My 1 result length " + result.size() + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.println("CombinationSumII My 1 result " + i + " during time " + (endTime - startTime));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<List<Integer>> testMy1(int[] nums, int target) {
        return getCombinationSumIIMy1(nums, target);
    }
}
