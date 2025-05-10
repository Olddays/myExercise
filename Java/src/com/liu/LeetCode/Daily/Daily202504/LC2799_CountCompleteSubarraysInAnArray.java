package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC2799_CountCompleteSubarraysInAnArray {

    // Beats 57.96%
    private static int countCompleteSubarraysMy1(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int distinct = set.size(); // 不同数字的个数
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0; // 双指针滑动窗口
        int right = 0;
        while (right < length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() == distinct) {
                result += length - right; // 因为是连续的，所以后面的数字都可以作为子数组的结尾
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++; // 当满足后，不断移动left，并每次都进行记录，直到不满足，再开始移动fight扩大
            }
            right++; // 先向右移动，直到map.size()==distinct，在map中保存的已遍历的内容包含每个不同的数字
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 3, 1, 2, 2},
                {5, 5, 5, 5},
        };
        long[] resultList = new long[]{
                4,
                10,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countCompleteSubarraysMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countCompleteSubarrays My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
