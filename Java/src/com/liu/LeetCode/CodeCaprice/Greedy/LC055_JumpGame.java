package com.liu.LeetCode.CodeCaprice.Greedy;

public class LC055_JumpGame {

    // Greedy
    // Beats 79.75%
    private static boolean canJumpMy1(int[] nums) {
        int length = nums.length;
        int maxReach = 0;
        for (int i = 0; i < length; i++) {
            if (i > maxReach) {
                // 到不了当前的i位置
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        // 已经可以到最后一个位置了
        return maxReach >= length - 1;
    }

    public static void main(String[] args) {
        int[][] pricesList = new int[][]{
                {2, 3, 1, 1, 4},
                {3, 2, 1, 0, 4},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < pricesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = canJumpMy1(pricesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canJump My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
