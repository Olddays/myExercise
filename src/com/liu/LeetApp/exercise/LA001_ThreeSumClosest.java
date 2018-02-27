package com.liu.LeetApp.exercise;

import java.util.Arrays;

/**
 * Created by baidu on 2016/11/27.
 */
public class LA001_ThreeSumClosest {

    // Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    // Return the sum of the three integers. You may assume that each input would have exactly one solution.

    // For example, given array S = {-1 2 1 -4}, and target = 1.
    // The sum that is closest to the target is 2.

    // Difficulty: Medium

    // Error 没有考虑当三个数据并不连续时的情况
    public static int getThreeSumClosestMy1(int[] input, int target) {
        Arrays.sort(input);
        int result = target;
        int closest = Integer.MAX_VALUE;
        for (int i = 1; i < input.length - 1; i++) {
            int sumCache = input[i - 1] + input[i] + input[i + 1];
            int gapCache = Math.abs(target - sumCache);
            if (gapCache < closest) {
                closest = gapCache;
                result = sumCache;
            }
        }
        return result;
    }

    // Error 写出了死循环,因为left恒小于right
    public static int getThreeSumClosestMy2(int[] input, int target) {
        Arrays.sort(input);
        int result = target;
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < input.length - 2; i++) {
            int left = i + 1;
            int right = input.length - 1;
            while (left < right) {
                int sumCache = input[left] + input[i] + input[right];
                int gapCache = Math.abs(target - sumCache);
                if (gapCache < closest) {
                    closest = gapCache;
                    result = sumCache;
                }
            }
        }
        return result;
    }

    public static int getThreeSumClosestAnswer(int[] input, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (input == null || input.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(input);
        int closest = Integer.MAX_VALUE / 2; // Otherwise it will overflow for operation (closest - target).
        for (int i = 0; i < input.length - 2; i++) {
            int left = i + 1;
            int right = input.length - 1;
            while (left < right) {
                int sum = input[i] + input[left] + input[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                closest = Math.abs(sum - target) < Math.abs(closest - target) ? sum : closest;
            }
        }
        return closest;
    }
}
