package com.liu.LeetCode.CodeCaprice.SingleStack;

import java.util.*;

public class LC084_LargestRectangleInHistogram {
    // 单调栈，递增栈
    // Beats 41.14%
    private static int largestRectangleAreaMy1(int[] heights) {
        int length = heights.length;
        int max = 0;
        int[] newHeights = new int[length + 2]; // 0到等于length是因为要考虑两边的边界情况，在while计算中是无法计算小于3个柱子的情况的
        newHeights[0] = 0;
        newHeights[length + 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, length);
        Stack<Integer> singleStack = new Stack<>();
        singleStack.push(0);
        for (int i = 1; i < length + 2; i++) {
            // 对每个柱子，都去求左边比他矮和右边比他矮的，然后就得到了宽，再乘自己的高度，就是以这个柱子为基准的矩形面积
            // 如果确保栈是单调递增的，那么栈的头就是最大值，那么当出现比自己小的新的数据要入栈的时候，就等于找到了这个节点为基准的长度
            while (!singleStack.isEmpty() && newHeights[singleStack.peek()] > newHeights[i]) {
                int index = singleStack.pop(); // 当前最高柱子
                if (!singleStack.isEmpty()) {
                    int leftIndex = singleStack.peek(); // 最高柱子左边比他小的柱子
                    int width = i - leftIndex - 1;
                    int height = newHeights[index];
                    max = Math.max(max, width * height);
                }
            }
            singleStack.push(i);
        }
        return max;
    }

    // 暴力破解
    // Time Limit Exceeded
    private static int largestRectangleAreaMy2(int[] heights) {
        int length = heights.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < length && heights[right] >= heights[i]) {
                right++;
            }
            int width = right - left - 1;
            int height = heights[i];
            max = Math.max(max, width * height);
        }
        return max;
    }

    // 双指针
    // Beats 95.15%
    private static int largestRectangleAreaMy3(int[] heights) {
        int length = heights.length;
        int max = 0;
        int[] leftHeights = new int[length];
        int[] rightHeights = new int[length];
        leftHeights[0] = -1;
        rightHeights[length - 1] = length;
        for (int i = 1; i < length; i++) {
            int leftTemp = i - 1;
            while (leftTemp >= 0 && heights[leftTemp] >= heights[i]) {
                leftTemp = leftHeights[leftTemp];
            }
            leftHeights[i] = leftTemp;
        }
        for (int i = length - 2; i >= 0; i--) {
            int rightTemp = i + 1;
            while (rightTemp < length && heights[rightTemp] >= heights[i]) {
                rightTemp = rightHeights[rightTemp];
            }
            rightHeights[i] = rightTemp;
        }
        for (int i = 0; i < length; i++) {
            int width = rightHeights[i] - leftHeights[i] - 1;
            int height = heights[i];
            max = Math.max(max, width * height);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] heightsSet = new int[][]{
                {2, 1, 5, 6, 2, 3},
                {2, 4},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < heightsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = largestRectangleAreaMy1(heightsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("largestRectangleArea My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < heightsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = largestRectangleAreaMy2(heightsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("largestRectangleArea My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < heightsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = largestRectangleAreaMy3(heightsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("largestRectangleArea My3 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
