package com.liu.LeetCode.ThirtyDays202006.test;

import com.liu.LeetCode.ThirtyDays202006.exercise.TD05_RandomPickWithWeight.Solution;

/**
 * Created by Liu on 2020/6/5.
 */
public class TD05_RandomPickWithWeight_Test {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        int[] nums = new int[]{
                3, 14, 1, 7
        };
        Solution solution = new Solution(nums);
        for (int i = 0; i < 10; i++) {
            startTime = System.currentTimeMillis();
            int result = solution.pickIndex();
            endTime = System.currentTimeMillis();
            System.out.println("TD04_ReverseString My 1 result " + result + " during time " + (endTime - startTime));
        }
    }
}
