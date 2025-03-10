package com.liu.LeetCode.CodeCaprice.SingleStack;

import java.util.*;

public class LC042_TrappingRainWater {

    // Time Limit Exceeded
    private static int trapMy1(int[] height) {
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1) { // 规避两侧
                continue;
            }
            int leftHeight = height[i]; // 左边最高元素
            for (int left = i - 1; left >= 0; left--) {
                if (height[left] > leftHeight) {
                    leftHeight = height[left];
                }
            }
            int rightHeight = height[i]; // 右边最高元素
            for (int right = i + 1; right < length; right++) {
                if (height[right] > rightHeight) {
                    rightHeight = height[right];
                }
            }
            int h = Math.min(leftHeight, rightHeight) - height[i];
            if (h > 0) {
                count += h;
            }
        }
        return count;
    }

    // 双指针优化
    // Beats 64.21%
    private static int trapMy2(int[] height) {
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        int count = 0;
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 0; i < length; i++) {
            int h = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (h > 0) {
                count += h;
            }
        }
        return count;
    }

    // 单调栈
    // Beats 5.23%
    private static int trapMy3(int[] height) {
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        int count = 0;
        Stack<Integer> singleStack = new Stack<>();
        singleStack.push(0);
        for (int i = 1; i < length; i++) {
            if (height[i] < height[singleStack.peek()]) {
                singleStack.push(i);
            } else if (height[i] == height[singleStack.peek()]) {
                singleStack.pop();
                singleStack.push(i);
            } else {
                // 遍历过程中，如果找到了比当前栈顶元素大的元素，就开始记录，如果记录出来发现比当前第一大的那就是一侧的高度，另一侧的高度就是比当前第二大的
                while (!singleStack.isEmpty() && height[singleStack.peek()] < height[i]) {
                    int mid = singleStack.pop();
                    if (!singleStack.isEmpty()) {
                        int h = Math.min(height[singleStack.peek()], height[i]) - height[mid];
                        int w = i - singleStack.peek() - 1;
                        count += h * w;
                    }
                }
                singleStack.push(i);
            }
        }
        return count;
    }

    // Beats 100.00%
    private static int trapMy4(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        // Two pointer approach
        while (left <= right) {
            if (height[left] <= height[right]) {
                // If the current height at left is less than or equal to the height at right
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update leftMax
                } else {
                    totalWater += leftMax - height[left]; // Water trapped at left
                }
                left++;
            } else {
                // If the current height at right is less than height at left
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update rightMax
                } else {
                    totalWater += rightMax - height[right]; // Water trapped at right
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[][] heightSet = new int[][]{
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
                {4, 2, 0, 3, 2, 5},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < heightSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = trapMy1(heightSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("trap My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < heightSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = trapMy2(heightSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("trap My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < heightSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = trapMy3(heightSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("trap My3 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
