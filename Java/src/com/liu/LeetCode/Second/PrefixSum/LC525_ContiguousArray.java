package com.liu.LeetCode.Second.PrefixSum;

import java.util.HashMap;

public class LC525_ContiguousArray {

    private static int findMaxLengthMy1(int[] nums) {
        // 错误，向左查只看多少个0
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        if (nums[nums.length - 1] == 0 || nums[nums.length - 1] == nums.length) {
            return result;
        }
        int left = 0;
        int right = 1;
        while (left < right && right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
                continue;
            }
            // 起点左查
            if (nums[right] <= right - left) {
                result = Math.max(result, nums[right] * 2);
            } else {
                result = Math.max(result, (right - left) * 2);
            }
            left++;
            right++;
        }
        return result;
    }

    private static int findMaxLengthAnswer1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                result = Math.max(i + 1, result);
            }
            if (map.containsKey(sum)) {
                result = Math.max(i - map.get(sum), result);
            } else {
                map.put(sum, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 1, 1},
                {0, 1},
                {0},
                {0, 1, 0},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findMaxLengthMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("ContiguousArray My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
        numsList = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 1, 1},
                {0, 1},
                {0},
                {0, 1, 0},
        };
        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findMaxLengthAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("ContiguousArray Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }

}
