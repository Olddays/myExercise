package com.liu.LeetCode.CodeCaprice.DP;

public class LC213_HouseRobberII {

    private static int robMy1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // DP[i] 表示偷到第i家的最大金额
        int[] dpFirst = new int[length];
        dpFirst[0] = nums[0];
        dpFirst[1] = Math.max(nums[0], nums[1]);
        int[] dpLast = new int[length];
        dpLast[0] = 0;
        dpLast[1] = nums[1];
        dpLast[2] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < length; i++) {
            // 如果是环，那么就有三个情况
            // 偷第一个不偷最后一个、偷最后一个不偷第一个、第一个和最后一个都不偷
            // 情况一、二包含了情况三，所以只需要考虑情况一和二
            // dp[i-1]偷不偷仅仅是考虑，并不一定，要根据dp过程决定，要根据dp[i-2]决定
            // 因为如果dp[i-1]偷了，那么dp[i]就不能偷了，所以要根据dp[i-2]决定
            dpFirst[i] = Math.max(dpFirst[i - 1], nums[i] + dpFirst[i - 2]);
            dpLast[i] = Math.max(dpLast[i - 1], nums[i] + dpLast[i - 2]);
        }
        return Math.max(dpFirst[length - 2], dpLast[length - 1]);
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {0, 0},
                {2, 1, 1, 2},
                {1, 2, 3, 1},
                {1, 2, 3},
                {2, 7, 9, 3, 1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = robMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("rob My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
