package com.liu.LeetCode.Daily.Daily202504;

public class LC3375_MinimumOperationsToMakeArrayValuesEqualToK {
    // Beats 100.00%
    private static int minOperationsMy1(int[] nums, int k) {
        // nums[i]最大值是100
        boolean[] cache = new boolean[101];
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (!cache[num] && num > k) {
                count++;
            }
            cache[num] = true;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {5, 2, 5, 4, 5},
                {2, 1, 2},
                {9, 7, 5, 3},
        };
        int[] kList = new int[]{
                2,
                2,
                1,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minOperationsMy1(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minOperations My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
