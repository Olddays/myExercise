package com.liu.LeetCode.ThirtyDays202004.test;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD02_HappyNum.isHappy;

public class TD02_HappyNum_Test {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 11, 15, 19};
        boolean result;
        long startTime;
        long endTime;

        for (int num : nums) {
            startTime = System.currentTimeMillis();
            result = testMy1(num);
            endTime = System.currentTimeMillis();
            System.out.println("TD02_HappyNum My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static boolean testMy1(int n) {
        return isHappy(n);
    }

}
