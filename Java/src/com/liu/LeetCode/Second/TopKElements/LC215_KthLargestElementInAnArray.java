package com.liu.LeetCode.Second.TopKElements;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC215_KthLargestElementInAnArray {

    private static int findKthLargestMy1(int[] nums, int k) { // accepted 多一个循环，性能比较差
        int result = -1;
        int length = nums.length;
        if (length < k) {
            return result;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            heap.add(num);
        }
        for (int i = 0; i < length + 1 - k; i++) { // 此循环是多余的，可以结合到第一个里面
            result = heap.poll();
        }
        return result;
    }

    private static int findKthLargestMy2(int[] nums, int k) { // accepted 剪掉了一个for，但是性能一般
        int length = nums.length;
        if (length < k) {
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else {
                heap.add(num);
                heap.poll();
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {3, 2, 1, 5, 6, 4},
                {3, 2, 3, 1, 2, 4, 5, 5, 6},
        };
        int[] kSet = new int[]{
                2,
                4,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findKthLargestMy1(numsSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findKthLargest My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findKthLargestMy2(numsSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findKthLargest My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
