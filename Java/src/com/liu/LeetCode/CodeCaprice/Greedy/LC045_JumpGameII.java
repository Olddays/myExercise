package com.liu.LeetCode.CodeCaprice.Greedy;

public class LC045_JumpGameII {

    // Beats 99.44%
    private static int jumpMy1(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        int maxCount = 0;
        int timesOfJump = 0;
        int lastJumpIdx = 0;
        for (int i = 0; i < length; i++) {
            maxCount = Math.max(maxCount, i + nums[i]);
            if (i == lastJumpIdx) {
                lastJumpIdx = maxCount;
                timesOfJump++;
                // check if we reached destination already
                if (maxCount >= length - 1) {
                    return timesOfJump;
                }
            }
        }
        return timesOfJump;
    }

    public static void main(String[] args) {
        int[][] pricesList = new int[][]{
                {2, 1, 1, 1, 1},
                {2, 0, 2, 0, 1},
                {1, 2},
                {2, 3, 1, 1, 4},
                {3, 2, 1, 0, 4},
                {0},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < pricesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = jumpMy1(pricesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("jump My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
