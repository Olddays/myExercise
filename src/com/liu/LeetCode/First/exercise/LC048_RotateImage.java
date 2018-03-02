package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC048_RotateImage {
    /**
     * ou are given an n x n 2D matrix representing an image.
     * <p>
     * Rotate the image by 90 degrees (clockwise).
     * <p>
     * Note:
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
     * <p>
     * Example 1:
     * <p>
     * Given input matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     * <p>
     * Example 2:
     * <p>
     * Given input matrix =
     * [
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     */

    // 找到的规律是:设有m行n列矩阵,则第a行变为新的n行m列矩阵的第(m+1)-a列(此处的m,n,a均为正常值,非数组值)
    // 问题是需要创建新的空间来存放数组,应该省略这一步
    public static void getRotateImageMy1(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int list = matrix[0].length;
        if (list == 0) {
            return;
        }
        int[][] result = new int[list][row];
        for (int i = 0; i < row; i++) { // 行
            for (int j = 0; j < list; j++) { // 列
                int newRow = j;
                int newList = row - 1 - i;
                result[newRow][newList] = matrix[i][j];
            }
        }
        matrix = result;
        for (int i = 0; i < matrix.length; i++) {
            int[] line = matrix[i];
            System.out.println("line: " + i);
            for (int index : line) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }

    // 找到的规律是:设有m行n列矩阵,则第a行变为新的n行m列矩阵的第(m+1)-a列(此处的m,n,a均为正常值,非数组值)
    // 其实我们可以分两步走,第一步先将矩阵行列互换,第二步再将每一列用中间列对称互换即可,或将第一二步反过来
    // 这种互换方式只能工作在输入矩阵的长宽相等的情况下,否则会数组越界
    public static void getRotateImageMy2(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int list = matrix[0].length;
        if (list == 0) {
            return;
        }
        // 时间复杂度 nlog(n)
        for (int i = 0; i < row; i++) { // 行
            for (int j = i; j < list; j++) { // 列
                // 此处j = i,即只更换对角线一侧的数据,如果j = 0那么会在循环的时候将数据进行两次更换,则会换回原始状态
                int cache = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = cache;
            }
        }
        // 时间复杂度 n²/2
        for (int i = 0; i < list; i++) { // 新行
            for (int j = 0; j < row / 2; j++) { // 新列
                // 此处j < row / 2,即只以中间列堆成的一侧的数据,如果j < row那么会在循环的时候将数据进行两次更换,则会换回原始状态
                int newList = row - 1 - j;
                int cache = matrix[i][j];
                matrix[i][j] = matrix[i][newList];
                matrix[i][newList] = cache;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] line = matrix[i];
            System.out.println("line: " + i);
            for (int index : line) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }
}
