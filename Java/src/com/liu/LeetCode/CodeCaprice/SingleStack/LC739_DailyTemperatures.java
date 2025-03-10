package com.liu.LeetCode.CodeCaprice.SingleStack;

import java.util.Stack;

public class LC739_DailyTemperatures {
    // Beats 52.01%
    private static int[] dailyTemperaturesMy1(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> singleStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!singleStack.isEmpty() && temperatures[i] > temperatures[singleStack.peek()]) {
                int index = singleStack.pop();
                result[index] = i - index;
            }
            singleStack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] temperaturesSet = new int[][]{
                {73, 74, 75, 71, 69, 72, 76, 73},
                {30, 40, 50, 60},
                {30, 60, 90},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < temperaturesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = dailyTemperaturesMy1(temperaturesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("dailyTemperatures My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
