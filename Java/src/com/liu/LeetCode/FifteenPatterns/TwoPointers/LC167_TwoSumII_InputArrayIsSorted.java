package com.liu.LeetCode.FifteenPatterns.TwoPointers;

public class LC167_TwoSumII_InputArrayIsSorted {

    private static int[] twoSumMy1(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        if (right <= 0) {
            return result;
        }
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, -1},
                {3, 4, 7, -2, 2, 1, 4, 2},
                {1, 1, 1},
                {1, 2, 3},
        };
        int[] ks = new int[]{
                0,
                7,
                2,
                3,
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = twoSumMy1(numsList[i], ks[i]);
            endTime = System.currentTimeMillis();
            System.out.println("TwoSum My1 result" + i + " " + result[0] + " " + result[1] + " during time " + (endTime - startTime));
        }
    }
}
