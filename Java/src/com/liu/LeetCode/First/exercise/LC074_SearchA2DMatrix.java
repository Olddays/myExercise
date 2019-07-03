package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC074_SearchA2DMatrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * <p>
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * <p>
     * For example,
     * <p>
     * Consider the following matrix:
     * <p>
     * [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * <p>
     * Given target = 3, return true.
     */

    // 没有规避输入[[]]的情况
    public static boolean getSearchA2DMatrixMy1(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int targetRow = -1;
        for (int i = 0; i < row; i++) {
            int[] rowNums = matrix[i];
            if (rowNums[0] > target) {
                targetRow = i - 1;
                break;
            }
        }
        if (targetRow >= 0) {
            int[] rowNums = matrix[targetRow];
            int left = 0;
            int right = rowNums.length - 1;
            while (left < right) {
                if (rowNums[left] < target) {
                    left++;
                } else if (rowNums[left] == target) {
                    return true;
                }
                if (rowNums[right] > target) {
                    right--;
                } else if (rowNums[right] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 没有考虑输入[[1]],1的情况
    public static boolean getSearchA2DMatrixMy2(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int list = matrix[0].length;
        if (list == 0) {
            return false;
        }
        int targetRow = -1;
        for (int i = 0; i < row; i++) {
            int[] rowNums = matrix[i];
            if (rowNums[0] > target) {
                targetRow = i - 1;
                break;
            }
        }
        if (targetRow >= 0) {
            int[] rowNums = matrix[targetRow];
            int left = 0;
            int right = list - 1;
            while (left < right) {
                if (rowNums[left] < target) {
                    left++;
                } else if (rowNums[left] == target) {
                    return true;
                }
                if (rowNums[right] > target) {
                    right--;
                } else if (rowNums[right] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getSearchA2DMatrixMy3(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int list = matrix[0].length;
        if (list == 0) {
            return false;
        }
        int targetRow = row - 1;
        for (int i = 0; i < row; i++) {
            int[] rowNums = matrix[i];
            if (rowNums[0] > target) {
                targetRow = i - 1;
                break;
            } else if (rowNums[0] == target) {
                targetRow = i;
                break;
            }
        }
        if (targetRow >= 0) {
            int[] rowNums = matrix[targetRow];
            int left = 0;
            int right = list - 1;
            while (left <= right) {
                if (rowNums[left] < target) {
                    left++;
                } else if (rowNums[left] == target) {
                    return true;
                }
                if (rowNums[right] > target) {
                    right--;
                } else if (rowNums[right] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
