package com.liu.LeetCode.CodeCaprice.SingleStack;

import java.util.Arrays;
import java.util.Stack;

public class LC503_NextGreaterElementII {
    // Beats 76.52%
    private static int[] nextGreaterElementsMy1(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Stack<Integer> singleStack = new Stack<>();
        for (int i = 0; i < length * 2 - 1; i++) {
            while (!singleStack.isEmpty() && nums[singleStack.peek()] < nums[i % length]) {
                result[singleStack.pop()] = nums[i % length];
            }
            singleStack.push(i % length);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1, 2, 1},
                {1, 2, 3, 4, 3},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = nextGreaterElementsMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("nextGreaterElements My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
