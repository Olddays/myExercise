package com.liu.LeetCode.ThirtyDays202004.exercise;

/**
 * Created by Liu on 2020/4/26.
 */
public class TD25_JumpGame {
    // Time Limit Exceeded
    public static boolean canJumpMy1(int[] nums) {
        int length = nums.length;
        return length != 0 && checkJumpMy1(nums, 0, length);
    }

    private static boolean checkJumpMy1(int[] nums, int local, int length) {
        int jump = nums[local];
        if (local + jump + 1 >= length) {
            return true;
        }
        for (int i = 1; i <= jump; i++) {
            if (checkJumpMy1(nums, i + local, length)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canJumpMy2(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, nums[i] + i);
        }
        return true;
    }

}
