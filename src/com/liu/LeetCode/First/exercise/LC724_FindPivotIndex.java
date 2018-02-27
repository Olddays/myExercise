package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC724_FindPivotIndex {
    /**
     * Given an array of integers nums, write a method that returns the "pivot" index of this array.
     * <p>
     * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
     * <p>
     * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * nums = [1, 7, 3, 6, 5, 6]
     * Output: 3
     * Explanation:
     * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
     * Also, 3 is the first index where this occurs.
     * <p>
     * Example 2:
     * <p>
     * Input:
     * nums = [1, 2, 3]
     * Output: -1
     * Explanation:
     * There is no index that satisfies the conditions in the problem statement.
     * <p>
     * Note:
     * The length of nums will be in the range [0, 10000].
     * Each element nums[i] will be an integer in the range [-1000, 1000].
     */

    public static int getFindPivotIndexMy1(int[] nums) {
        int length = nums.length;
        int result = -1;
        if (length == 0) {
            return result;
        }
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];
        int cache = 0;
        for (int i = 0; i < length; i++) {
            cache += nums[i];
            leftSum[i] = cache;
        }
        cache = 0;
        int index = 0;
        for (int i = length - 1; i >= 0; i--) {
            cache += nums[i];
            rightSum[index++] = cache;
        }
        for (int i = 0; i < length; i++) {
            if (leftSum[i] == rightSum[length - 1 - i]) {
                return i;
            }
        }
        return result;
    }

    public static int getFindPivotIndexAnswer1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int sum = 0;
        int left = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                left += nums[i - 1];
            }
            if (sum - left - nums[i] == left) {
                return i;
            }
        }
        return -1;
    }
}
