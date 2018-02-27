package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC643_MaximumAverageSubarrayI {
    /**
     * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,12,-5,-6,50,3], k = 4
     * Output: 12.75
     * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
     * <p>
     * Note:
     * <p>
     * 1 <= k <= n <= 30,000.
     * Elements of the given array will be in the range [-10,000, 10,000].
     */

    public static double getMaximumAverageSubarrayIMy1(int[] nums, int k) {
        int length = nums.length;
        if (length < k) {
            return 0;
        }
        int left = 0;
        int right = k;
        double maxAverage = Integer.MIN_VALUE; // 规避负数出现,不能用0
        while (right < length + 1) { // 保证最后一个值也被遍历到
            int cache = 0;
            for (int i = left; i < right; i++) {
                cache += nums[i];
            }
            maxAverage = Math.max(maxAverage, (double) cache / k);
            left++;
            right++;
        }
        return maxAverage;
    }

    public static double getMaximumAverageSubarrayIAnswer1(int[] nums, int k) {
        int length = nums.length;
        if (length < k) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / 1.0 / k;
    }
}
