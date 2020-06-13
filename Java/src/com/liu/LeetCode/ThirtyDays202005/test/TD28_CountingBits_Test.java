package com.liu.LeetCode.ThirtyDays202005.test;


import static com.liu.LeetCode.ThirtyDays202005.exercise.TD28_CountingBits.countBits;

/**
 * Created by Liu on 2020/5/28.
 */
public class TD28_CountingBits_Test {
    public static void main(String[] args) {
        int[] numList = new int[]{
                3, 4, 5, 16
        };
        int[] result;
        long startTime;
        long endTime;

        for (int num : numList) {
            startTime = System.currentTimeMillis();
            result = testMy1(num);
            endTime = System.currentTimeMillis();
            System.out.println("TD28_CountingBits My 1 result.size " + result.length + " during time " + (endTime - startTime));
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[] testMy1(int num) {
        return countBits(num);
    }
}
