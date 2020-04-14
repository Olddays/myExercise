package com.liu.LeetCode.ThirtyDays202004.test;


import static com.liu.LeetCode.ThirtyDays202004.exercise.TD01_SingleNumber.singleNumber;

public class TD01_SingleNum_Test {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_SingleNum My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return singleNumber(nums);
    }

}
