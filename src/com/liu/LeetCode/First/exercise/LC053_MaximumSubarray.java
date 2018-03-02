package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC053_MaximumSubarray {
    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * <p>
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     * <p>
     * More practice:
     * <p>
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     */

    // 首先:由于无序,左右夹逼没有意义;
    // 时间复杂度nlog(n),导致时间过长
    public static int getMaximumSubarrayMy1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int cache = nums[i];
            result = Math.max(result, cache);
            if (nums[i] <= 0) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                cache += nums[j];
                result = Math.max(result, cache);
            }
        }
        return result;
    }

    // 使用DP(动态规划)来处理问题,找到的子问题是maxSubArray(int A[], int i, int j)也就是对于A[i:j]时能提供的最大和子串之和
    public static int getMaximumSubarrayAnswer1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length]; // dp[i]表示nums[0:i]的最大和子串之和
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < length; i++) { // 对于nums[0]已经处理过了,所以跳过nums[0],i从1开始遍历
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0); // 前一个最大子串和大于0则增加,否则即可以认为此值对于增加result无用
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // 此处认为当sum小于0时,可以直接重新开始计算
    public static int getMaximumSubarrayAnswer2(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            if (sum < 0)
                sum = num;
            else
                sum += num;
            if (sum > max)
                max = sum;
        }
        return max;
    }
}
