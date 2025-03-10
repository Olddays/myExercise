package com.liu.LeetCode.CodeCaprice.SingleStack;

import java.util.*;

public class LC496_NextGreaterElementI {

    // Beats 90.26%
    private static int[] nextGreaterElementMy1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int[] result = new int[length1];
        Stack<Integer> singleStack = new Stack<>(); // 单增栈，也就是找nums2的每一个元素的下一个更大的值
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!singleStack.isEmpty() && num > singleStack.peek()) {
                int cache = singleStack.pop();
                map.put(cache, num);
            }
            singleStack.push(num);
        }
        for (int i = 0; i < length1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums1Set = new int[][]{
                {4, 1, 2},
                {2, 4},
        };
        int[][] nums2Set = new int[][]{
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
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
