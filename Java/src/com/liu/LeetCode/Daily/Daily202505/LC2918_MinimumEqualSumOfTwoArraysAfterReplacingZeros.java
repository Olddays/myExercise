package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

public class LC2918_MinimumEqualSumOfTwoArraysAfterReplacingZeros {

    // Beats 88.73%
    private static long minSumMy1(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        long zero1 = 0, zero2 = 0;
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) zero1++;
        }
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) zero2++;
        }
        if (sum1 + zero1 < sum2 + zero2 && zero1 == 0 || sum2 + zero2 < sum1 + zero1 && zero2 == 0) {
            return -1;
        }
        // zero1 * x + sum1 = zero2 * y + sum2;
        // 理论替换的最小sum 就是sum1+zero1 和 sum2+zero2 也就是所有的0都换成1
        return Math.max(sum1 + zero1, sum2 + zero2);
    }

    public static void main(String[] args) {
        int[][] nums1List = new int[][]{
                {3, 2, 0, 1, 0},
                {2, 0, 2, 0},
        };
        int[][] nums2List = new int[][]{
                {6, 5, 0},
                {1, 4},
        };
        long[] resultList = new long[]{
                12,
                -1,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = minSumMy1(nums1List[i], nums2List[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minSum My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
