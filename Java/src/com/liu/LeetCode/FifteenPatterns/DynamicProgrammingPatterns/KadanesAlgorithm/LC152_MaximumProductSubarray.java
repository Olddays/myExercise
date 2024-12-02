package com.liu.LeetCode.FifteenPatterns.DynamicProgrammingPatterns.KadanesAlgorithm;

// 这个题目的思路和LC53_MaximumSubarray一样，只是需要考虑到负数的情况
// 所以需要考虑到当前的最大值和最小值，因为最小值乘以一个负数就会变成最大值，最大值乘以一个负数就会变成最小值
// 所以需要同时考虑到当前的最大值和最小值，然后再考虑到当前的数字，然后再取最大值
public class LC152_MaximumProductSubarray {
    // 无法处理-2,3,-4
    private static int maxProductMy1(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        max[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
            maxProduct = Math.max(maxProduct, max[i]);
        }
        return maxProduct;
    }

    // 无法处理 0，2
    private static int maxProductMy2(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = nums[0];
        min[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < length; i++) {
            int nowMax = max[i - 1] * nums[i];
            int nowMin = min[i - 1] * nums[i];
            max[i] = Math.max(nowMax, nums[i]);
            min[i] = Math.min(nowMin, nums[i]);
            maxProduct = Math.max(Math.max(maxProduct, nowMax), nowMin);
        }
        return maxProduct;
    }

    // 无法处理-1,-2,-9,-6
    private static int maxProductMy3(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = nums[0];
        min[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < length; i++) {
            int nowMax = max[i - 1] * nums[i];
            int nowMin = min[i - 1] * nums[i];
            max[i] = Math.max(Math.max(nowMax, nowMin), nums[i]);
            min[i] = Math.min(nowMin, nums[i]);
            maxProduct = Math.max(maxProduct, max[i]);
        }
        return maxProduct;
    }

    // 性能一般 Beats16.86%
    private static int maxProductMy4(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = nums[0];
        min[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < length; i++) {
            int nowMax = max[i - 1] * nums[i];
            int nowMin = min[i - 1] * nums[i];
            max[i] = Math.max(Math.max(nowMax, nowMin), nums[i]);
            min[i] = Math.min(Math.min(nowMax, nowMin), nums[i]);
            maxProduct = Math.max(maxProduct, max[i]);
        }
        return maxProduct;
    }

    private static int maxProductAnswer1(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int pro = 1;
        for (int num : nums) {
            pro *= num;
            maxValue = Math.max(maxValue, pro);
            if (pro == 0) pro = 1;
        }
        pro = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            pro *= nums[i];
            maxValue = Math.max(maxValue, pro);
            if (pro == 0) pro = 1;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {-1, -2, -9, -6},
                {0, 2},
                {-2, 3, -4},
                {2, 3, -2, 4},
                {-2, 0, -1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProductMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProduct My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProductMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProduct My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProductMy3(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProduct My3 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProductMy4(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProduct My4 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProductAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProduct Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
