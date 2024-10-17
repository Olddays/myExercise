package com.liu.LeetCode.Second.SlidingWindow;

public class LC643_MaximumAverageSubarrayI {

    private static double findMaxAverageMy1(int[] nums, int k) {
        double result = 0;
        int length = nums.length;
        if (length < k) {
            return result;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result = (double) sum / k;
        for (int i = 1; i < length + 1 - k; i++) {
            sum = sum - nums[i - 1] + nums[i - 1 + k];
            result = Math.max(result, (double) sum / k);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {0, 1, 1, 3, 3},
                {1, 12, -5, -6, 50, 3},
        };
        int[] ks = new int[]{
                4,
                4,
        };
        double result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findMaxAverageMy1(numsList[i], ks[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findMaxAverage My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
