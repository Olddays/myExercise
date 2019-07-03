package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC238_ProductOfArrayExceptSelf {
    /**
     * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     * <p>
     * Solve it without division and in O(n).
     * <p>
     * For example, given [1,2,3,4], return [24,12,8,6].
     * <p>
     * Follow up:
     * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
     */

    // 没有考虑过输入有0的情况
    public static int[] getProductOfArrayExceptSelfMy1(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        if (length == 0) {
            return result;
        }
        int total = 1;
        for (int num : nums) {
            total *= num;
        }
        for (int i = 0; i < length; i++) {
            result[i] = total / nums[i];
        }
        return result;
    }

    public static int[] getProductOfArrayExceptSelfMy2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        if (length == 0) {
            return result;
        }
        int cache = 0;
        for (int num : nums) {
            if (num == 0) {
                cache++;
            }
        }
        boolean hasZero = false;
        if (cache >= 2) {
            return result;
        } else if (cache == 1) {
            hasZero = true;
        }
        int total = 1;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            total *= num;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                result[i] = total;
            } else {
                if (hasZero) {
                    result[i] = 0;
                } else {
                    result[i] = total / nums[i];
                }
            }
        }
        return result;
    }

    public static int[] getProductOfArrayExceptSelfAnswer1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
