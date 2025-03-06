package com.liu.LeetCode.CodeCaprice.DP.Package01;

public class LC494_TargetSum {

    // 转化为背包问题，每个nums种的数据，都需要选择正和负，最后要达成一个等式
    // 也就是分成两组，一组要选择做正数的数和一组要选择做负数的数和，且正数和+负数和=target
    // 假设要选择做正数的数和是left，要选择做负数的数和是right，则
    // left + right = sum 且 left - right = target
    // 两式相加则 2left = sum + target，也就是 left = (sum + target) / 2
    // Beats 93.39%
    // https://leetcode.cn/problems/target-sum/solutions/816361/mu-biao-he-by-leetcode-solution-o0cp/
    private static int findTargetSumWaysMy1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(sum + target) % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        int left = Math.abs(sum + target) / 2; // 正数的集合
        // 装满空间为j的背包，有多少种方法
        int[] dp = new int[left + 1];
        dp[0] = 1; // 装满容量为0的方法，有一种
        for (int num : nums) {
            for (int j = left; j >= num; j--) {
                // 如果求dp[4]，那么就要看有哪些num，num0是0，那就有dp[4]个，num1是2，那就有dp[2]个，如果num1是3，那就有dp[1]个方法
                dp[j] += dp[j - num];
            }
        }
        return dp[left];
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1, 1, 1, 1, 1},
                {1},
        };
        int[] targetSet = new int[]{
                3,
                1,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findTargetSumWaysMy1(numsSet[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findTargetSumWays My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
