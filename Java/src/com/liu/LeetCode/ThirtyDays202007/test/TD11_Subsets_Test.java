package com.liu.LeetCode.ThirtyDays202007.test;

import java.util.List;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD11_Subsets.subsets;

/**
 * Created by Liu on 2020/7/13.
 */
public class TD11_Subsets_Test {

    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> result;
        long startTime;
        long endTime;


        nums = new int[]{
                1, 2, 3
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD11_Subsets My 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<List<Integer>> testMy1(int[] nums) {
        return subsets(nums);
    }
}
