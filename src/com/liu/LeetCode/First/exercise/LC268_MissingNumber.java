package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC268_MissingNumber {
    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     * <p>
     * For example,
     * Given nums = [0, 1, 3] return 2.
     * <p>
     * Note:
     * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     */

    // 没有考虑过输入有0的情况
    public static int getMissingNumberMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 1; i < length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                return nums[i] - 1;
            }
        }
        if (nums[0] == 0) {
            return nums[length - 1] + 1;
        } else {
            return 0;
        }
    }

    // The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
    // In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
    public static int getMissingNumberAnswer1(int[] nums) {
        // 直接按位异或了,可以啊这个答案
        int xor = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    // 这也是个骚操作,直接首尾求和得到预期之后算差
    public static int getMissingNumberAnswer2(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    // 二分查找
    public static int getMissingNumberAnswer3(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
