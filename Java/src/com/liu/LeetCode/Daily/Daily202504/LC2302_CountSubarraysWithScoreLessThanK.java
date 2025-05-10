package com.liu.LeetCode.Daily.Daily202504;

public class LC2302_CountSubarraysWithScoreLessThanK {

    // brute force
    // Time Limit Exceeded
    private static long countSubarraysMyError1(int[] nums, long k) {
        int length = nums.length;
        long count = 0;
        for (int left = 0; left < length; left++) {
            long sum = nums[left];
            if (sum < k) {
                count++;
            } else {
                continue;
            }
            for (int right = left + 1; right < length; right++) {
                sum += nums[right];
                if (sum * (right - left + 1) < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    // 双指针滑动窗口，核心是left一直往前走
    // Beats 100.00%
    private static long countSubarraysMy1(int[] nums, long k) {
        int length = nums.length;
        long sum = 0;
        long count = 0;
        int left = 0;
        for (int right = 0; right < length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1; // 子数组的个数
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 1, 1},
                {2, 1, 4, 3, 5},
        };
        int[] kList = new int[]{
                5,
                10,
        };
        long[] resultList = new long[]{
                5,
                6,
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
