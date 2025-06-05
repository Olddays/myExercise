package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

public class LC3024_TypeOfTriangle {

    // Beats 100.00%
    private static String triangleTypeMy1(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }
        if (nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1] || nums[1] + nums[2] <= nums[0]) {
            return "none";
        }
        if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) {
            return "isosceles";
        }
        return "scalene";
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {8, 4, 4},
                {3, 3, 3},
                {3, 4, 5},
                {5, 3, 8},
                {2, 7, 7},
        };
        String[] resultList = new String[]{
                "none",
                "equilateral",
                "scalene",
                "none",
                "isosceles",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = triangleTypeMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("triangleType My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
