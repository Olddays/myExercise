package com.liu.LeetCode.Daily.Daily202504;

public class LC3392_CountSubarraysOfLengthThreeWithACondition {

    // brute force
    // Beats 100%
    private static int countSubarraysMy1(int[] nums) {
        int length = nums.length;
        int result = 0;
        int left = 0;
        int right = 2;
        while (right < length) {
            if ((nums[left] + nums[right]) * 2 == nums[right - 1]) {
                result++;
            }
            left++;
            right++;
        }
        return result;
    }

    // Beats 100%
    private static int countSubarraysMy2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = nums[i] + nums[i + 2];
            if (nums[i + 1] == sum * 2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 2, 1, 4, 1},
                {1, 1, 1},
        };
        int[] resultList = new int[]{
                1,
                0,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countSubarraysMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countSubarrays My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countSubarraysMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countSubarrays My2 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
