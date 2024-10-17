package com.liu.LeetCode.Second.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class LC084_LargestRectangleInHistogram {
    private static int largestRectangleAreaMy1(int[] heights) { // accepted 性能不好
        int result = 0;
        int length = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 处理左侧
        for (int i = 0; i < length + 1; i++) {
            int height;
            if (i == length) {
                height = 0; // 处理右侧
            } else {
                height = heights[i];
            }
            while (stack.peek() != -1 && heights[stack.peek()] > height) {
                int leftHeight = heights[stack.pop()];
                int leftWidth = i - stack.peek() - 1;
                result = Math.max(result, leftHeight * leftWidth);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {2, 1, 5, 6, 2, 3},
                {2, 4, 6, 8},
                {8, 6, 4, 2},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = largestRectangleAreaMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("largestRectangleArea My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
