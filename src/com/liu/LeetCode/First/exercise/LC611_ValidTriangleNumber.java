package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by liu on 2017/9/30.
 */
public class LC611_ValidTriangleNumber {
    /**
     * Given an array consists of non-negative integers,
     * your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
     * <p>
     * Example 1:
     * <p>
     * Input: [2,2,3,4]
     * Output: 3
     * Explanation:
     * Valid combinations are:
     * 2,3,4 (using the first 2)
     * 2,3,4 (using the second 2)
     * 2,2,3
     * <p>
     * Note:
     * <p>
     * The length of the given array won't exceed 1000.
     * The integers in the given array are in the range of [0, 1000].
     */

    public static int getValidTriangleNumberMy1(int[] nums) {
        int length = nums.length;
        int result = 0;
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] > nums[k]
                            && nums[i] > 0 && nums[j] > 0 && nums[k] > 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }


    // Same as https://leetcode.com/problems/3sum-closest
    // Assume a is the longest edge, b and c are shorter ones, to form a triangle, they need to satisfy len(b) + len(c) > len(a).
    public static int getValidTriangleNumberAnswer1(int[] nums) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
