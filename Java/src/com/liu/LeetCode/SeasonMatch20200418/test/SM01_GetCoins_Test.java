package com.liu.LeetCode.SeasonMatch20200418.test;

import static com.liu.LeetCode.SeasonMatch20200418.exercise.SM01_GetCoins.minCount;

public class SM01_GetCoins_Test {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 1};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_SingleNum My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return minCount(nums);
    }

}
