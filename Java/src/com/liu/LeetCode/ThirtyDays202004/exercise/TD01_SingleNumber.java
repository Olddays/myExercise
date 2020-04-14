package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD01_SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }
}
