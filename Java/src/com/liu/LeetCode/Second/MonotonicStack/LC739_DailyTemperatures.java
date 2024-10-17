package com.liu.LeetCode.Second.MonotonicStack;

import java.util.HashMap;
import java.util.Stack;

public class LC739_DailyTemperatures {
    private static int[] dailyTemperaturesMy1(int[] temperatures) { // accepted 性能一般
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int num = stack.pop();
                result[num] = i - num;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {73, 74, 75, 71, 69, 72, 76, 73},
                {30, 40, 50, 60},
                {30, 60, 90},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = dailyTemperaturesMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("dailyTemperatures My1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
