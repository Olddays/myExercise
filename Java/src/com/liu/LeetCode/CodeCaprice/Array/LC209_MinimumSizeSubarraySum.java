package com.liu.LeetCode.CodeCaprice.Array;

public class LC209_MinimumSizeSubarraySum {

    // 暴力寻找的话，时间复杂度有问题，所以应该使用滑动窗口的方式
    // 滑动窗口，就是一前一后两个指针
    // 如果固定起始位置，移动终止位置的话，那就跟暴力破解一样了
    // 滑动窗口的核心，就是如何移动起始位置

    // 先向后移动终止位置，当发现一个符合条件的解时，可以收缩起始位置直到不能满足
    // 此时继续滑动终止，直到完全遍历
    private static int minSubArrayLenMy1(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (sum < target) {
                sum += nums[end];
                end++;
            }
            // 注意这里要是while，不一定一次就完成移动，所以要while
            while (sum >= target) {
                result = Math.min(result, end - start);
                sum -= nums[start];
                start++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {2, 3, 1, 2, 4, 3},
                {1, 4, 4},
                {1, 1, 1, 1, 1, 1, 1, 1},
        };
        int[] targetList = new int[]{
                7,
                4,
                11,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minSubArrayLenMy1(targetList[i], numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minSubArrayLen My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
