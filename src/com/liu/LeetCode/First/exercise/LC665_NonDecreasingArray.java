package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC665_NonDecreasingArray {
    /**
     * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
     * <p>
     * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
     * <p>
     * Example 1:
     * <p>
     * Input: [4,2,3]
     * Output: True
     * Explanation: You could modify the first
     * 4
     * to
     * 1
     * to get a non-decreasing array.
     * <p>
     * Example 2:
     * <p>
     * Input: [4,2,1]
     * Output: False
     * Explanation: You can't get a non-decreasing array by modify at most one element.
     * <p>
     * Note: The n belongs to [1, 10,000].
     */

    // 无法处理[3,4,1,2]这种输入
    public static boolean getNonDecreasingArrayMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
            }
        }
        return count <= 1;
    }

    // 无法处理 2, 3, 3, 2, 4 的情况
    public static boolean getNonDecreasingArrayMy2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        int count = 0;
        int minNum = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] > nums[minNum]) {
                count++;
            }
            if (nums[minNum] > nums[i]) {
                minNum = i;
            }
        }
        return count <= 1;
    }

    public static boolean getNonDecreasingArrayMy3(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        int minNum = length - 1;
        int maxNum = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > nums[maxNum]) {
                maxNum = i;
            }
            if (nums[minNum] > nums[i]) {
                minNum = i;
            }
        }
        return !(maxNum != length - 1 && minNum != 0);
    }

    // This problem is like a greedy problem.
    // When you find nums[i-1] > nums[i] for some i,
    // you will prefer to change nums[i-1]'s value,
    // since a larger nums[i] will give you more risks that you get inversion errors after position i.
    // But, if you also find nums[i-2] > nums[i],
    // then you have to change nums[i]'s value instead,
    // or else you need to change both of nums[i-2]'s and nums[i-1]'s values.
    public static boolean getNonDecreasingArrayAnswer1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        int count = 0; // the number of changes
        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) { // 往前看俩看看是否能接着继续
                    nums[i - 1] = nums[i]; // modify nums[i-1] of a priority
                } else {
                    nums[i] = nums[i - 1]; //have to modify nums[i]
                }
            }
        }
        return count <= 1;
    }
}
