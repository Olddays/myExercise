package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD04_NumberComplement.findComplementMy1;
import static com.liu.LeetCode.ThirtyDays202005.exercise.TD04_NumberComplement.findComplementAnswer1;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD04_NumberComplement_Test {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2, 11};
        int result;
        long startTime;
        long endTime;

        for (int num : nums) {
            startTime = System.currentTimeMillis();
            result = testMy1(num);
            endTime = System.currentTimeMillis();
            System.out.println("TD04_NumberComplement My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(num);
            endTime = System.currentTimeMillis();
            System.out.println("TD04_NumberComplement My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int num) {
        return findComplementMy1(num);
    }


    private static int testAnswer1(int num) {
        return findComplementAnswer1(num);
    }

}
