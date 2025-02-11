package com.liu.LeetCode.Second;

import java.util.ArrayList;
import java.util.List;

public class LC054_SpiralMatrix {

    public static List<Integer> spiralOrderMy1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int startX = 0;
        int startY = 0;
        int endX = matrix.length;
        if (endX == 0) {
            return result;
        }
        int endY = matrix[0].length;
        if (endY == 0) {
            return result;
        }
        while (startX < endX && startY < endY) {
            for (int i = startY; i < endY; i++) {
                result.add(matrix[startX][i]);
            }
            startX++;
            for (int i = startX; i < endX; i++) {
                result.add(matrix[i][endY - 1]);
            }
            endY--;
            if (!(startX < endX && startY < endY)) {
                // 规避单数列时重复计算
                break;
            }
            for (int i = endY - 1; i >= startY; i--) {
                result.add(matrix[endX - 1][i]);
            }
            endX--;
            for (int i = endX - 1; i >= startX; i--) {
                result.add(matrix[i][startY]);
            }
            startY++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][][] numsList = new int[][][]{
                {
                        {1}, {2}, {3},
                        {4}, {5}, {6},
                        {7}, {8}, {9}, {10}
                }, {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        },
        };

        List<Integer> result;
        long startTime;
        long endTime;

        for (int[][] nums : numsList) {
            startTime = System.currentTimeMillis();
            result = spiralOrderMy1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("SpiralMatrix My 1 result.size: " + result.size() + " during time " + (endTime - startTime));
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
