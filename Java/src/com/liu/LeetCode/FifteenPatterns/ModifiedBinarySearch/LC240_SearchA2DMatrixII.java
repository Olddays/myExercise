package com.liu.LeetCode.FifteenPatterns.ModifiedBinarySearch;

public class LC240_SearchA2DMatrixII {

    private static boolean searchMatrixMy1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0; // 从第一行开始
        int col = matrix[0].length - 1; // 从最后一列开始
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                // 与某一列的最小值相比要小
                // 说明col的列都大于target，所以col左移
                col--;
            } else if (matrix[row][col] < target) {
                // 与某一列的最大值相比要大
                // 说明row的行都小于target，所以row下移
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][][] matrixSet = new int[][][]{
                {
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                },
                {
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                },
        };
        int[] targetSet = new int[]{
                5,
                20,
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < matrixSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = searchMatrixMy1(matrixSet[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("searchMatrix My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
