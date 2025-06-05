package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC73_SetMatrixZeroes {

    // Beats 72.83%
    private static void setZeroesMy1(int[][] matrix) {
        List<int[]> zeroPoints = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroPoints.add(new int[]{i, j});
                }
            }
        }
        for (int[] zeroPoint : zeroPoints) {
            int row = zeroPoint[0];
            int col = zeroPoint[1];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][][] matrixList = new int[][][]{
                {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
                {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}},
        };
        int[][][] resultList = new int[][][]{
                {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}},
                {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}},
        };
        long startTime;
        long endTime;

        for (int i = 0; i < matrixList.length; i++) {
            startTime = System.currentTimeMillis();
            setZeroesMy1(matrixList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("setZeroes My1 result" + i + " ");
            for (int j = 0; j < resultList[i].length; j++) {
                System.out.print("line " + j + " " + Arrays.toString(resultList[i][j]) + ", ");
            }
            System.out.println(" result " + Utils.compareResult(matrixList[i], resultList[i]) + " during time " + (endTime - startTime));
        }
    }
}
