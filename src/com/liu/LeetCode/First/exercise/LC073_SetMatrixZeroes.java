package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC073_SetMatrixZeroes {
    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
     * <p>
     * Follow up:
     * <p>
     * Did you use extra space?
     * A straight forward solution using O(mn) space is probably a bad idea.
     * A simple improvement uses O(m + n) space, but still not the best solution.
     * Could you devise a constant space solution?
     */

    // 输入长宽不一致的时候会导致数组越界,比如[0,1]
    public static void getSetMatrixZeroesMy1(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int list = matrix[0].length;
        List<Integer> zeroCache = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                if (matrix[i][j] == 0) {
                    zeroCache.add(i);
                    zeroCache.add(j);
                }
            }
        }
        for (int i = 0; i < zeroCache.size(); i++) {
            int number = zeroCache.get(i);
            if (i % 2 == 0) {
                for (int j = 0; j < row; j++) {
                    matrix[number][j] = 0;
                }
            } else {
                for (int j = 0; j < list; j++) {
                    matrix[j][number] = 0;
                }
            }
        }
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < list; j++) {
                System.out.print(aMatrix[j] + " ");
            }
            System.out.println();
        }
    }

    // 此处占用空间为O(n),还可以有更小的O(1)
    public static void getSetMatrixZeroesMy2(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int list = matrix[0].length;
        List<Integer> zeroCache = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                if (matrix[i][j] == 0) {
                    zeroCache.add(i);
                    zeroCache.add(j);
                }
            }
        }
        for (int i = 0; i < zeroCache.size(); i++) {
            int number = zeroCache.get(i);
            if (i % 2 == 0) {
                // 此时number是行,故j应该为列
                for (int j = 0; j < list; j++) {
                    matrix[number][j] = 0;
                }
            } else {
                // 此时number是列,故j应该为行
                for (int j = 0; j < row; j++) {
                    matrix[j][number] = 0;
                }
            }
        }
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < list; j++) {
                System.out.print(aMatrix[j] + " ");
            }
            System.out.println();
        }
    }
}
