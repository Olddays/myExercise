package com.liu.LeetCode.CodeCaprice.Greedy;

import java.util.Arrays;

public class LC1005_MaximizeSumOfArrayAfterKNegations {

    // error
    private static int largestSumAfterKNegationsMy1(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int nonPositionCount = 0;
        for (int num : nums) {
            if (num <= 0) {
                nonPositionCount++;
            } else {
                break;
            }
        }
        if (nonPositionCount < k) {
            // 如果小于k，那么就等于把所有的负数变正数后，再变化k-negationCount次
            // 此时如果是奇数，那么就需要把最小的正数变负数，否则就不需要
            k = Math.abs(nonPositionCount - (k - nonPositionCount) % 2);
        }
        // 无法处理(-2,1,4,6),k=3的情况，会把1和4都变负数而不会重新把2变-2
        for (int num : nums) {
            if (k > 0) {
                sum += -num;
                k--;
            } else {
                sum += num;
            }
        }
        return sum;
    }

    // Beats 88.66%
    private static int largestSumAfterKNegationsMy2(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        int minAbs = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            minAbs = Math.min(minAbs, nums[i]);
            sum += nums[i];
        }
        if (k % 2 == 1) {
            sum -= minAbs * 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {4, 2, 3},
                {2, -3, -1, 5, -4},
                {8, -7, -3, -9, 1, 9, -6, -9, 3},
                {-2, 5, 0, 2, -2},
                {3, -1, 0, 2},
        };
        int[] kList = new int[]{
                1,
                2,
                8,
                7,
                3,
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = largestSumAfterKNegationsMy1(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("largestSumAfterKNegations My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = largestSumAfterKNegationsMy2(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("largestSumAfterKNegations My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
