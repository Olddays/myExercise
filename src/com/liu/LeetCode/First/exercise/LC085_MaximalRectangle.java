package com.liu.LeetCode.First.exercise;

import java.util.Stack;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC085_MaximalRectangle {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
     * <p>
     * For example, given the following matrix:
     * <p>
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * <p>
     * Return 6.
     */

    // The vector "left" is computing the left boundary. Take (i,j)=(1,3) for example. On current row 1, the left boundary is at j=2. However, because matrix[1][3] is 1, you need to consider the left boundary on previous row as well, which is 3. So the real left boundary at (1,3) is 3.
    // 思路超级巧妙啊
    public static int getMaximalRectangleAnswer1(char[][] matrix) {
        int result = 0;
        int row = matrix.length;
        if (row == 0) {
            return result;
        }
        int list = matrix[0].length;
        int left[] = new int[list];
        int right[] = new int[list];
        int height[] = new int[list];
        for (int i = 0; i < list; i++) {
            right[i] = list;
        }
        for (char[] aMatrix : matrix) {
            int cur_left = 0, cur_right = list;
            for (int j = 0; j < list; j++) { // compute height (can do this from either side)
                if (aMatrix[j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            System.out.print("");
            for (int j = 0; j < list; j++) { // compute left (from left to right)
                if (aMatrix[j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            System.out.print("");
            // compute right (from right to left)
            for (int j = list - 1; j >= 0; j--) {
                if (aMatrix[j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = list;
                    cur_right = j;
                }
            }
            System.out.print("");
            // compute the area of rectangle (can do this from either side)
            for (int j = 0; j < list; j++) {
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
            System.out.print("");
        }
        return result;
    }

    // First initiate the height array as 1 1 0 1 0 1, which is just a copy of the first row. Then we can easily calculate the max area is 2.
    // Then update the array. We scan the second row, when the matrix[1][i] is 0, set the height[i] to 0; else height[i] += 1, which means the height has increased by 1. So the height array again becomes 0 2 0 0 1 2. The max area now is also 2.
    // Apply the same method until we scan the whole matrix. the last height arrays is 2 4 2 2 0 4, so the max area has been found as 2 * 4 = 8.
    // Then reason we scan the whole matrix is that the maximum value may appear in any row of the height.
    public static int getMaximalRectangleAnswer2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestInLine(height);
        for (int i = 1; i < matrix.length; i++) {
            resetHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }

        return result;
    }

    private static void resetHeight(char[][] matrix, int[] height, int idx) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }

    public static int largestInLine(int[] height) {
        if (height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
