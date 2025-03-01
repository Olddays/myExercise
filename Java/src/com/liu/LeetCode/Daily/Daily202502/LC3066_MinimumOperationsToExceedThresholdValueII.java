package com.liu.LeetCode.Daily.Daily202502;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class LC3066_MinimumOperationsToExceedThresholdValueII {

    private static int minOperationsMy1(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        Arrays.sort(nums);
        if (nums[0] >= k) {
            return sum;
        }
        int i = 0;
        while (i < length - 1) {
            if (nums[i] >= k) {
                break;
            }
            sum++;
            int num1 = nums[i];
            int num2 = nums[i + 1];
            long newNum = (long) Math.min(num1, num2) * 2 + Math.max(num1, num2);
            if (newNum < k) {
                nums[i + 1] = (int) newNum;
                i++;
            } else if (i + 2 == length - 1 && newNum > nums[i + 2]) { // 尽管可以通过，但是这种不断打补丁的方法很不好，应该改用小顶堆
                nums[i + 1] = nums[i + 2];
                nums[i + 2] = (int) newNum;
            } else {
                i += 2;
            }
        }
        return sum;
    }

    // 小顶堆 Beats 92.59%
    private static int minOperationsMy2(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        if (nums[0] >= k) {
            return count;
        }
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long) num);
        }
        while (!minHeap.isEmpty()) {
            long num1 = minHeap.poll();
            if (num1 >= k || minHeap.isEmpty()) {
                return count;
            }
            count++;
            long num2 = minHeap.poll();
            long newNum = Math.min(num1, num2) * 2 + Math.max(num1, num2);
            minHeap.add(newNum);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999},
                {999999999, 999999999, 999999999},
                {2, 11, 10, 1, 3},
                {1, 1, 2, 4, 9},
        };
        int[] kList = new int[]{
                1000000000,
                1000000000,
                10,
                20,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minOperationsMy1(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minOperations My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minOperationsMy2(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minOperations My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
