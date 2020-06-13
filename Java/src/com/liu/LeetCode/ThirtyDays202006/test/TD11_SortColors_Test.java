package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD11_SortColors.sortColors;

/**
 * Created by Liu on 2020/6/11.
 */
public class TD11_SortColors_Test {
    public static void main(String[] args) {
        int[] nums;
        long startTime;
        long endTime;

        nums = new int[]{
                2, 0, 2, 1, 1, 0
        };
        startTime = System.currentTimeMillis();
        testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD11_SortColors My 1 during time " + (endTime - startTime));
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void testMy1(int[] nums) {
        sortColors(nums);
    }
}
