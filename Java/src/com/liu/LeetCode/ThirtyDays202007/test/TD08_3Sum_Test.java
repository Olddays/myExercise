package com.liu.LeetCode.ThirtyDays202007.test;

import java.util.List;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD08_3Sum.threeSum;

/**
 * Created by Liu on 2020/7/8.
 */
public class TD08_3Sum_Test {
    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> result;
        long startTime;
        long endTime;


        nums = new int[]{
                -1, 0, 1, 2, -1, -4
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD08_3Sum My 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<List<Integer>> testMy1(int[] nums) {
        return threeSum(nums);
    }
}
