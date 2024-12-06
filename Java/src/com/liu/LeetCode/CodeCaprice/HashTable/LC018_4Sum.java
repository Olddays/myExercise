package com.liu.LeetCode.CodeCaprice.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC018_4Sum {
    private static List<List<Integer>> fourSumMy1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 3; i++) {
            // 跳过重复的元素，但不跳过第0个位置，并且i跟i-1比较，是因为i-i已经用过了
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        // 跳过重复的元素，j和j-1相比，是因为j已经前移了，j-1已经用过了
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1000000000, 1000000000, 1000000000, 1000000000},
                {-3, -1, 0, 2, 4, 5},
                {1, 0, -1, 0, -2, 2},
                {2, 2, 2, 2, 2},
        };
        int[] targetSet = new int[]{
                -294967296,
                2,
                0,
                8,
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = fourSumMy1(numsSet[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("fourSum My1 result" + i + " ");
            for (List<Integer> list : result) {
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
