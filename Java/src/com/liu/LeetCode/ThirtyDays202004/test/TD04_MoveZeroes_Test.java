package com.liu.LeetCode.ThirtyDays202004.test;


import static com.liu.LeetCode.ThirtyDays202004.exercise.TD04_MoveZeroes.moveZeroes;

public class TD04_MoveZeroes_Test {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.print("TD04_MoveZeroes My 1 result: ");
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println(", during time " + (endTime - startTime));
    }

    private static void testMy1(int[] nums) {
        moveZeroes(nums);
    }

}
