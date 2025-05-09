package com.liu.LeetCode.CodeCaprice.DP;

public class LC198_HouseRobber {

    // error，不相邻即可，不是非得隔一个做一个
    private static int robMyError1(int[] nums) {
        int length = nums.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }
        return Math.max(sum1, sum2);
    }

    private static int robMy1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        // DP[i] 表示偷到第i家的最大金额
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            // dp[i-1]偷不偷仅仅是考虑，并不一定，要根据dp过程决定，要根据dp[i-2]决定
            // 因为如果dp[i-1]偷了，那么dp[i]就不能偷了，所以要根据dp[i-2]决定
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {2, 1, 1, 2},
                {1, 2, 3, 1},
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
