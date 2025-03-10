package com.liu.LeetCode.Second;

public class LC2962_CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    // Beats 82.64%
    private static long countSubarraysMy1(int[] nums, int k) {
        int length = nums.length;
        int max = 0;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        long result = 0;
        int count = 0;
        int left = 0;
        for (int right = 0; right < length; right++) {
            if (nums[right] == max) {
                count++;
            }
            while (count >= k) {
                int leftNum = nums[left];
                if (leftNum == max) {
                    count--;
                }
                left++;
            }
            result += left;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 3, 2, 3, 3},
                {1, 4, 2, 1},
        };
        int[] kList = new int[]{
                2,
                3,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countSubarraysMy1(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countSubarrays My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
