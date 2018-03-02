package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by liu on 2017/9/14.
 */
public class LC016_ThreeSumClosest {
    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * <p>
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * <p>
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */


    public static int getThreeSumClosestMy1(int[] nums, int target) {
        int closest = 65535;
        if (nums.length < 3) {
            return closest;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue; // to skip duplicate number; e.g [0, 0, 0, 0]
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int cast = sum - target;
                int oldCast = closest - target;
                closest = Math.abs(cast) > Math.abs(oldCast) ? closest : sum;
                if (cast == 0) {
                    return target;
                } else if (cast > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return closest;
    }
}
