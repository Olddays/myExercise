package com.liu.LeetCode.FifteenPatterns.MonotonicStack;

import java.util.Stack;

/**
 * The Monotonic Stack pattern uses a stack to maintain a sequence of elements in a specific order (increasing or decreasing).
 * Use this pattern for problems that require finding the next greater or smaller element.
 * Sample Problem:
 * Find the next greater element for each element in an array. Output -1 if the greater element doesn’t exist.
 * Example:
 * Input: nums = [2, 1, 2, 4, 3]
 * Output: [4, 2, 4, -1, -1]
 * Explanation:
 * Use a stack to keep track of elements for which we haven't found the next greater element yet.
 * Iterate through the array, and for each element, pop elements from the stack until you find a greater element.
 * If the stack is not empty, set the result for index at the top of the stack to current element.
 * Push the current element onto the stack.
 */

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
