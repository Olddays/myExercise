package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.Arrays;

public class LC1920_BuildArrayFromPermutation {

    // Beats 98.74%
    private static int[] buildArrayMy1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {0, 2, 1, 5, 3, 4},
                {5, 0, 1, 2, 3, 4},
        };
        int[][] resultList = new int[][]{
                {0, 1, 2, 4, 5, 3},
                {4, 5, 0, 1, 2, 3},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = buildArrayMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxTaskAssign My1 result" + i + " " + Arrays.toString(result) + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
