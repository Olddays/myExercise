package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC054_SpiralMatrix {
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * <p>
     * For example,
     * Given the following matrix:
     * <p>
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * <p>
     * You should return [1,2,3,6,9,8,7,4,5].
     */

    // 没有考虑输入为空
    public static List<Integer> getSpiralMatrixMy1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int list = matrix[0].length;
        int rowIndex = 0;
        while (rowIndex < (row + 1) / 2) {
            for (int i = rowIndex; i < list - rowIndex; i++) {
                result.add(matrix[rowIndex][i]); // 第rowIndex行
            }
            for (int i = rowIndex + 1; i < row - rowIndex; i++) {
                result.add(matrix[i][list - 1 - rowIndex]); // 第list - rowIndex列
            }
            for (int i = list - rowIndex - 2; i >= rowIndex; i--) {
                result.add(matrix[row - 1 - rowIndex][i]); // 第rowIndex的对称行倒序
            }
            for (int i = row - rowIndex - 2; i > rowIndex; i--) {
                result.add(matrix[i][rowIndex]); // 第list - rowIndex的对称列倒序
            }
            rowIndex++;
        }
        return result;
    }

    // 没有考虑输入只有一行或一列的时候的情况
    public static List<Integer> getSpiralMatrixMy2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return result;
        }
        int list = matrix[0].length;
        int rowIndex = 0;
        while (rowIndex < (row + 1) / 2) {
            for (int i = rowIndex; i < list - rowIndex; i++) {
                result.add(matrix[rowIndex][i]); // 第rowIndex行
            }
            for (int i = rowIndex + 1; i < row - rowIndex; i++) {
                result.add(matrix[i][list - 1 - rowIndex]); // 第list - rowIndex列
            }
            for (int i = list - rowIndex - 2; i >= rowIndex; i--) {
                result.add(matrix[row - 1 - rowIndex][i]); // 第rowIndex的对称行倒序
            }
            for (int i = row - rowIndex - 2; i > rowIndex; i--) {
                result.add(matrix[i][rowIndex]); // 第list - rowIndex的对称列倒序
            }
            rowIndex++;
        }
        return result;
    }

    public static List<Integer> getSpiralMatrixMy3(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return result;
        }
        int list = matrix[0].length;
        int rowIndex = 0;
        int listIndex = 0;
        while (rowIndex < (row + 1) / 2 && listIndex < (list + 1) / 2) {
            for (int i = rowIndex; i < list - rowIndex; i++) {
                result.add(matrix[rowIndex][i]); // 第rowIndex行
            }
            for (int i = listIndex + 1; i < row - listIndex; i++) {
                result.add(matrix[i][list - 1 - listIndex]); // 第list - rowIndex列
            }
            if (row - 1 - rowIndex != rowIndex) { // 用于规避只有一行
                for (int i = list - rowIndex - 2; i >= rowIndex; i--) {
                    result.add(matrix[row - 1 - rowIndex][i]); // 第rowIndex的对称行倒序
                }
            }
            if (list - 1 - listIndex != listIndex) { // 用于规避只有一列
                for (int i = row - listIndex - 2; i > listIndex; i--) {
                    result.add(matrix[i][listIndex]); // 第list - rowIndex的对称列倒序
                }
            }
            rowIndex++;
            listIndex++;
        }
        return result;
    }
}
