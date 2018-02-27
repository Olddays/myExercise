package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC566_ReshapeTheMatrix {
    /**
     * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
     * <p>
     * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
     * <p>
     * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
     * <p>
     * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * nums =
     * [[1,2], [3,4]]
     * r = 1, c = 4
     * Output:
     * [[1,2,3,4]]
     * Explanation:
     * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
     * <p>
     * Example 2:
     * <p>
     * Input:
     * nums =
     * [[1,2], [3,4]]
     * r = 2, c = 4
     * Output:
     * [[1,2], [3,4]]
     * Explanation:
     * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
     * <p>
     * Note:
     * <p>
     * The height and width of the given matrix is in range [1, 100].
     * The given r and c are all positive.
     */

    public static int[][] getReshapeTheMatrixMy1(int[][] nums, int r, int c) {
        int row = nums.length;
        if (row == 0) {
            return new int[row][];
        }
        int list = nums[0].length;
        if (row * list != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int cache = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                result[cache / c][cache % c] = nums[i][j];
                cache++;
            }
        }
        return result;
    }
}
