package com.liu.LeetCode.Second.MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC496_NextGreaterElementI {

    private static int[] nextGreaterElementMy1(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[][] nums1Set = new int[][]{
                {1, 4, 2},
                {1, 4, 2},
                {2, 4},
        };
        int[][] nums2Set = new int[][]{
                {1, 3, 4, 2},
                {1, 3, 4, 2},
                {1, 2, 3, 4},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = nextGreaterElementMy1(nums1Set[i], nums2Set[i]);
            endTime = System.currentTimeMillis();
            System.out.print("nextGreaterElement My1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
