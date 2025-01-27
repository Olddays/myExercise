package com.liu.LeetCode.Daily.Daily2020501;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC2661_FirstCompletelyPaintedRowOrColumn {

    // Beats 5.29%
    private static int firstCompleteIndexMy1(int[] arr, int[][] mat) {
        int length = arr.length;
        int row = mat.length;
        int column = mat[0].length;
        boolean[][] visited = new boolean[row][column];
        Map<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                map.put(mat[i][j], new Integer[]{i, j});
            }
        }
        for (int i = 0; i < length; i++) {
            Integer[] index = map.get(arr[i]);
            visited[index[0]][index[1]] = true;
            boolean isRow = true;
            for (int j = 0; j < column; j++) { // column
                if (!visited[index[0]][j]) {
                    isRow = false;
                    break;
                }
            }
            if (isRow) {
                return i;
            }
            isRow = true;
            for (int j = 0; j < row; j++) { // row
                if (!visited[j][index[1]]) {
                    isRow = false;
                    break;
                }
            }
            if (isRow) {
                return i;
            }
        }
        return length;
    }

    // Beats 62.50%
    // 通过记录每一行的列数和每一列的行数来判断是否整行整列，改了1个就减1
    private static int firstCompleteIndexAnswer1(int[] arr, int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        Map<Integer, int[]> positionMap = new HashMap<>();
        int[] rowCount = new int[row];
        int[] colCount = new int[column];
        Arrays.fill(rowCount, column);
        Arrays.fill(colCount, row);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                positionMap.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] pos = positionMap.get(arr[i]);
            rowCount[pos[0]] -= 1;
            colCount[pos[1]] -= 1;
            if (rowCount[pos[0]] == 0 || colCount[pos[1]] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arrList = new int[][]{
                {1, 4, 5, 2, 6, 3},
                {2, 8, 7, 4, 1, 3, 5, 6, 9},
                {1, 3, 4, 2},
        };
        int[][][] matList = new int[][][]{
                {{4, 3, 5}, {1, 2, 6}},
                {{3, 2, 5}, {1, 4, 6}, {8, 7, 9}},
                {{1, 4}, {2, 3}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = firstCompleteIndexMy1(arrList[i], matList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("firstCompleteIndex My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = firstCompleteIndexAnswer1(arrList[i], matList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("firstCompleteIndex Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
