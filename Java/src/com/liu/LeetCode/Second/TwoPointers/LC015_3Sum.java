package com.liu.LeetCode.Second.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC015_3Sum {

    private static List<List<Integer>> threeSumMy1(int[] nums) { // 固定一个点
        ArrayList<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {-1, 0, 1, 2, -1, -4},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = threeSumMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("ThreeSum My1 result" + i + " during time " + (endTime - startTime));
            for (List<Integer> list : result) {
                System.out.print("ThreeSum My1 result ");
                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
        }
    }
}
