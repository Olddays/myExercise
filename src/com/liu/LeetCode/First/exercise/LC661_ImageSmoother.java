package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC661_ImageSmoother {
    /**
     * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [[1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * Output:
     * [[0, 0, 0],
     * [0, 0, 0],
     * [0, 0, 0]]
     * Explanation:
     * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
     * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
     * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
     * <p>
     * Note:
     * <p>
     * The value in the given matrix is in the range of [0, 255].
     * The length and width of the given matrix are in the range of [1, 150].
     */

    public static int[][] getImageSmootherMy1(int[][] M) {
        int row = M.length;
        if (row == 0) {
            return new int[row][];
        }
        int list = M[0].length;
        int[][] result = new int[row][list];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                result[i][j] = getAverage(i, j, row, list, M);
            }
        }
        return result;
    }

    private static int getAverage(int i, int j, int row, int list, int[][] M) {
        int count;
        int firstLine = 0;
        int secondLine;
        int thirdLine = 0;
        if (row == 1 && list == 1) { // 只有一个值
            return M[0][0];
        } else if (row == 1) { // 只有一列
            if (j == 0) {
                secondLine = M[i][j];
                thirdLine = M[i][j + 1];
                count = 2;
            } else if (j == list - 1) {
                firstLine = M[i][j - 1];
                secondLine = M[i][j];
                count = 2;
            } else {
                firstLine = M[i][j - 1];
                secondLine = M[i][j];
                thirdLine = M[i][j + 1];
                count = 3;
            }
        } else if (list == 1) { // 只有一行
            if (i == 0) {
                secondLine = M[i][j] + M[i + 1][j];
                count = 2;
            } else if (i == row - 1) {
                secondLine = M[i - 1][j] + M[i][j];
                count = 2;
            } else {
                secondLine = M[i - 1][j] + M[i][j] + M[i + 1][j];
                count = 3;
            }
        } else {
            if (i == 0) {
                if (j == 0) {// 左上角
                    secondLine = M[i][j] + M[i + 1][j];
                    thirdLine = M[i][j + 1] + M[i + 1][j + 1];
                    count = 4;
                } else if (j == list - 1) { // 左下角
                    firstLine = M[i][j - 1] + M[i + 1][j - 1];
                    secondLine = M[i][j] + M[i + 1][j];
                    count = 4;
                } else { // 第一列
                    firstLine = M[i][j - 1] + M[i + 1][j - 1];
                    secondLine = M[i][j] + M[i + 1][j];
                    thirdLine = M[i][j + 1] + M[i + 1][j + 1];
                    count = 6;
                }
            } else if (i == row - 1) {
                if (j == 0) { // 右上角
                    secondLine = M[i - 1][j] + M[i][j];
                    thirdLine = M[i - 1][j + 1] + M[i][j + 1];
                    count = 4;
                } else if (j == list - 1) { // 右下角
                    firstLine = M[i - 1][j - 1] + M[i][j - 1];
                    secondLine = M[i - 1][j] + M[i][j];
                    count = 4;
                } else { // 最后一列
                    firstLine = M[i - 1][j - 1] + M[i][j - 1];
                    secondLine = M[i - 1][j] + M[i][j];
                    thirdLine = M[i - 1][j + 1] + M[i][j + 1];
                    count = 6;
                }
            } else if (j == 0) { // 第一行
                secondLine = M[i - 1][j] + M[i][j] + M[i + 1][j];
                thirdLine = M[i - 1][j + 1] + M[i][j + 1] + M[i + 1][j + 1];
                count = 6;
            } else if (j == list - 1) { // 最后一行
                firstLine = M[i - 1][j - 1] + M[i][j - 1] + M[i + 1][j - 1];
                secondLine = M[i - 1][j] + M[i][j] + M[i + 1][j];
                count = 6;
            } else { // 内部状态
                firstLine = M[i - 1][j - 1] + M[i][j - 1] + M[i + 1][j - 1];
                secondLine = M[i - 1][j] + M[i][j] + M[i + 1][j];
                thirdLine = M[i - 1][j + 1] + M[i][j + 1] + M[i + 1][j + 1];
                count = 9;
            }
        }
        return (firstLine + secondLine + thirdLine) / count;
    }

    // Here we have a check function to check the boundary and a inner double loop to traverse the 9 potential candidates:
    public static int[][] getImageSmootherAnswer1(int[][] M) {
        if (M == null) {
            return null;
        }
        int rows = M.length;
        if (rows == 0) {
            return new int[0][];
        }
        int cols = M[0].length;
        int[][] result = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = 0;
                int sum = 0;
                for (int incR : new int[]{-1, 0, 1}) {
                    for (int incC : new int[]{-1, 0, 1}) {
                        if (isValid(row + incR, col + incC, rows, cols)) {
                            count++;
                            sum += M[row + incR][col + incC];
                        }
                    }
                }
                result[row][col] = sum / count;
            }
        }
        return result;
    }

    private static boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
