package com.liu.LeetCode.Daily.Daily202504;

public class LC1295_FindNumbersWithEvenNumberOfDigits {

    // Beats 98.76%
    private static int findNumbersMy1(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int num : nums) {
            double cache = (Math.log10(num) + 1);
            if ((int) (Math.log10(num) + 1) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {12, 345, 2, 6, 7896},
                {555, 901, 482, 1771},
        };
        int[] resultList = new int[]{
                2,
                1,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findNumbersMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findNumbers My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
