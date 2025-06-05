package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

public class LC1550_ThreeConsecutiveOdds {

    // Beats 100.00%
    private static boolean threeConsecutiveOddsMy1(int[] arr) {
        int length = arr.length;
        if (length < 3) {
            return false;
        }
        for (int i = 2; i < length; i++) {
            if (arr[i - 2] % 2 == 1 && arr[i - 1] % 2 == 1 && arr[i] % 2 == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arrList = new int[][]{
                {2, 6, 4, 1},
                {1, 2, 34, 3, 4, 5, 7, 23, 12},
        };
        boolean[] resultList = new boolean[]{
                false,
                true,
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = threeConsecutiveOddsMy1(arrList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("threeConsecutiveOdds My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
