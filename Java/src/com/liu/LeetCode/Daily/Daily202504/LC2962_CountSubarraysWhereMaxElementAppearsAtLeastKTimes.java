package com.liu.LeetCode.Daily.Daily202504;

public class LC2962_CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    // Beats 84.53%
    private static long countSubarraysMy1(int[] nums, int k) {
        int length = nums.length;
        int max = 0;
        for (int num : nums) {
            if (num> max) {
                max = num;
            }
        }
        long result = 0;
        int left = 0;
        int right = 0;
        int maxCount = 0;
        while (right < length) {
            if (nums[right] == max) {
                maxCount++;
            }
            while (left <= right && maxCount >= k) {
                // 基于当前已经有k个max的情况下，left一直走到有k-1个max，此时left的位置前面这些都是符合要求的，共left个数组
                // 因为右侧固定，也就是左侧每次少一个共left个
                if (nums[left] == max) {
                    maxCount--;
                }
                left++;
            }
            result += left;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82},
                {1, 3, 2, 3, 3},
                {1, 4, 2, 1},
        };
        int[] kList = new int[]{
                2,
                2,
                3,
        };
        long[] resultList = new long[]{
                224,
                6,
                0,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countSubarraysMy1(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countSubarrays My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
