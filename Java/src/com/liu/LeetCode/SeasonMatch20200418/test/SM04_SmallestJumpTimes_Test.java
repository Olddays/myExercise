package com.liu.LeetCode.SeasonMatch20200418.test;


import static com.liu.LeetCode.SeasonMatch20200418.exercise.SM04_SmallestJumpTimes.minJumpMy1;
import static com.liu.LeetCode.SeasonMatch20200418.exercise.SM04_SmallestJumpTimes.minJumpMy2;

public class SM04_SmallestJumpTimes_Test {

    public static void main(String[] args) {
        int[] nums;
        int result;
        long startTime;
        long endTime;


        nums = new int[]{2, 5, 1, 1, 1, 1};

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SM04_SmallestJumpTimes My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SM04_SmallestJumpTimes My 2 result " + result + " during time " + (endTime - startTime));


        nums = new int[]{2, 1, 1, 1, 1, 1};

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SM04_SmallestJumpTimes My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SM04_SmallestJumpTimes My 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return minJumpMy1(nums);
    }

    private static int testMy2(int[] nums) {
        return minJumpMy2(nums);
    }

}
