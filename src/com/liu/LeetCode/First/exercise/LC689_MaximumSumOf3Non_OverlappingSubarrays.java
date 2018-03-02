package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC689_MaximumSumOf3Non_OverlappingSubarrays {
    /**
     * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
     * <p>
     * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
     * <p>
     * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,1,2,6,7,5,1], 2
     * Output: [0, 3, 5]
     * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
     * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
     * <p>
     * Note:
     * nums.length will be between 1 and 20000.
     * nums[i] will be between 1 and 65535.
     * k will be between 1 and floor(nums.length / 3).
     */

    // 这个题目肯定是动态规划DP问题,则可以认为子问题是三个部分各自的最大子串,那么如何划分为三个部分,那么应该先找到中间的那个部分
    // 中间部分一定要在k到length-k的范围内寻找,否则第一和第三位置就会不够数据
    // 但是按照My1的方案有问题,我们没有遍历所有可能,只是暴力的寻找数据,无法适配[7, 13, 20, 19, 19, 2, 10, 1, 1, 19], 3的输入
    public static int[] getMaximumSumOf3Non_OverlappingSubarraysMy1(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[3];
        if (3 * k > length){
            return result;
        }
        int sum = 0;
        int midStart = 0;
        for (int i = k; i < length - 2 * k; i++) {
            int cache = 0;
            for (int j = i; j < i + k; j++) {
                cache += nums[j];
            }
            if (cache > sum) {
                sum = cache;
                midStart = i;
            }
        }
        int firstStart = 0;
        sum = 0;
        for (int i = 0; i < midStart - k; i++) {
            int cache = 0;
            for (int j = i; j < i + k; j++) {
                cache += nums[j];
            }
            if (cache > sum) {
                sum = cache;
                firstStart = i;
            }
        }
        int thirdStart = 0;
        sum = 0;
        for (int i = midStart + k; i < length - k; i++) {
            int cache = 0;
            for (int j = i; j < i + k; j++) {
                cache += nums[j];
            }
            if (cache > sum) {
                sum = cache;
                thirdStart = i;
            }
        }
        result[0] = firstStart;
        result[1] = midStart;
        result[2] = thirdStart;
        return result;
    }

    // 在1的基础上,我们可以认为中间数组开头可能的取值是从k到length-2k的范围
    // Time Limit Exceeded 时间复杂度过高, 可以进行压缩
    public static int[] getMaximumSumOf3Non_OverlappingSubarraysMy2(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[3];
        if (3 * k > length){
            return result;
        }
        int[][] midDp = new int[length - 3 * k + 1][4]; // 存储中间位置子串开头的可能性所能到达的最大值
        for (int mid = k; mid <= length - 2 * k; mid++) {
            int cache = 0;
            for (int j = mid; j < mid + k; j++) {
                cache += nums[j];
            }
            midDp[mid - k][0] += cache;
            midDp[mid - k][2] = mid;

            int firstStart = 0;
            int sum = 0;
            for (int i = 0; i <= mid - k; i++) {
                cache = 0;
                for (int j = i; j < i + k; j++) {
                    cache += nums[j];
                }
                if (cache > sum) {
                    sum = cache;
                    firstStart = i;
                }
            }
            midDp[mid - k][0] += sum;
            midDp[mid - k][1] = firstStart;
            int thirdStart = 0;
            sum = 0;
            for (int i = mid + k; i <= length - k; i++) {
                cache = 0;
                for (int j = i; j < i + k; j++) {
                    cache += nums[j];
                }
                if (cache > sum) {
                    sum = cache;
                    thirdStart = i;
                }
            }
            midDp[mid - k][0] += sum;
            midDp[mid - k][3] = thirdStart;
        }
        int id = 0;
        int sum = 0;
        for (int i = 0; i <= length - 3 * k; i++) {
            int[] dp = midDp[i];
            if (dp[0] > sum) {
                sum = dp[0];
                id = i;
            }
        }
        result[0] = midDp[id][1];
        result[1] = midDp[id][2];
        result[2] = midDp[id][3];
        return result;
    }

    // /**/The question asks for three non-overlapping intervals with maximum sum of all 3 intervals.
    // If the middle interval is [i, i+k-1], where k <= i <= n-2k, the left interval has to be in subrange [0, i-1],
    // and the right interval is from subrange [i+k, n-1].
    //
    // So the following solution is based on DP.
    // posLeft[i] is the starting index for the left interval in range [0, i];
    // posRight[i] is the starting index for the right interval in range [i, n-1];
    //
    // Then we test every possible starting index of middle interval, i.e. k <= i <= n-2k,
    // and we can get the corresponding left and right max sum intervals easily from DP.
    // And the run time is O(n).
    // Caution. In order to get lexicographical smallest order, when there are two intervals with equal max sum,
    // always select the left most one. So in the code, the if condition is ">= tot" for right interval due to backward searching,
    // and "> tot" for left interval. Thanks to @lee215 for pointing this out!
    public static int[] getMaximumSumOf3Non_OverlappingSubarraysAnswer1(int[] nums, int k) {
        int n = nums.length;
        int maxSum = 0;
        int[] sum = new int[n + 1];
        int[] posLeft = new int[n];
        int[] posRight = new int[n];
        int[] ans = new int[3];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        // DP for starting index of the left max sum interval
        for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                posLeft[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }
        // DP for starting index of the right max sum interval
        // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        posRight[n - k] = n - k;
        for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i + k] - sum[i];
            } else {
                posRight[i] = posRight[i + 1];
            }
        }
        // test all possible middle interval
        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i - 1];
            int r = posRight[i + k];
            int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (tot > maxSum) {
                maxSum = tot;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
}
