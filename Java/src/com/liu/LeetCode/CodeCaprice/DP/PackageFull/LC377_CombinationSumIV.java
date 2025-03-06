package com.liu.LeetCode.CodeCaprice.DP.PackageFull;

public class LC377_CombinationSumIV {

    // Beats 73.72%
    private static int combinationSum4My1(int[] nums, int target) {
        int[] dp = new int[target + 1]; // dp[i]表示目标为i时的组合数
        dp[0] = 1; // 当目标为0时只有一种组合
       /* for (int num : nums) {
            for (int i = num; i <= target; i++) {
                dp[i] += dp[i - num];
            }
        } // 无序*/
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num < 0) {
                    continue;
                }
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1, 2, 3},
                {9},
        };
        int[] targetSet = new int[]{
                4,
                3,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = combinationSum4My1(numsSet[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("combinationSum4 My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
