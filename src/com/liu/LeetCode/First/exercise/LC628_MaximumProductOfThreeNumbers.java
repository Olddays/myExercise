package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC628_MaximumProductOfThreeNumbers {
    /**
     * Given an integer array, find three numbers whose product is maximum and output the maximum product.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3]
     * Output: 6
     * <p>
     * Example 2:
     * <p>
     * Input: [1,2,3,4]
     * Output: 24
     * <p>
     * Note:
     * <p>
     * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
     * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
     */

    // 没有考虑负数的情况,即输入[-4,-3,-2,-1,60]时
    public static int getMaximumProductOfThreeNumbersMy1(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        int result = 1;
        Arrays.sort(nums); // 时间复杂度为O(nlog(n))
        for (int i = 1; i <= 3; i++) {
            result *= nums[length - i];
        }
        return result;
    }

    public static int getMaximumProductOfThreeNumbersMy2(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        Arrays.sort(nums); // 时间复杂度为O(nlog(n))
        int max = 1;
        for (int i = 1; i <= 3; i++) {
            max *= nums[length - i];
        }
        int min = nums[length - 1];
        for (int i = 0; i < 2; i++) {
            min *= nums[i];
        }
        return Math.max(max, min);
    }

    public static int getMaximumProductOfThreeNumbersAnswer1(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
