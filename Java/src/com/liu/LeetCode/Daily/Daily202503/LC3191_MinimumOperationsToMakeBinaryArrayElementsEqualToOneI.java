package com.liu.LeetCode.Daily.Daily202503;

public class LC3191_MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

    // 移动窗口
    // Beats 10.27%
    private static int minOperationsMy1(int[] nums) {
        int length = nums.length;
        int count = 0;
        int left = 0;
        boolean hasZero = false;
        for (int right = 0; right < length; right++) {
            if (hasZero) {
                if (right - left == 2) {
                    count++;
                    for (int j = left; j <= right; j++) {
                        nums[j] ^= 1;
                    }
                    while (left < length - 1 && left <= right && nums[left] == 1) {
                        left++;
                    }
                    right = left;
                    hasZero = false;
                }
            } else {
                left = right;
            }
            if (nums[right] == 0) {
                hasZero = true;
            }
        }
        return hasZero ? -1 : count;
    }

    // 也是滑动窗口，但是不需要回溯和复杂判断，时间复杂度更低，等于变成一个指针的固定窗口
    // Beats 100.00%
    private static int minOperationsAnswer1(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] == 0) { // 遇到0就把接下来的三个都进行异或操作，并且把count加1
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                count += 1;
            }
        }
        if (nums[length - 1] == 0 || nums[length - 2] == 0) { // 如果一直做到最后，发现还有0，那么就返回-1
            return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 1, 1, 1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minOperationsMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minOperations My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minOperationsAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minOperations Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
