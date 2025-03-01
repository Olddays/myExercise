package com.liu.LeetCode.CodeCaprice.Greedy;

public class LC376_WiggleSubsequence {

    // Beats 100.00%
    private static int wiggleMaxLengthMy1(int[] nums) {
        int length = nums.length;
        int result = 0;
        int preDiff = 0;
        int curDiff = 0;
        for (int i = 0; i < length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        result++; // 六个点五个diff，最后补一个结束点
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 7, 4, 9, 2, 5},
                {1, 17, 5, 10, 13, 15, 10, 5, 16, 8},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = wiggleMaxLengthMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("wiggleMaxLength My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
