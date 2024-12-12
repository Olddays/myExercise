package com.liu.LeetCode.CodeCaprice.StackQueue;

import java.util.*;

public class LC239_SlidingWindowMaximum {
    // 性能很差 Beats5.03%
    private static int[] maxSlidingWindowMy1(int[] nums, int k) {
        int n = nums.length;
        int resultSize = n - k + 1;
        int max = Integer.MIN_VALUE;
        int maxLocation = 0;
        int[] result = new int[resultSize];
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxLocation = i;
            }
        }
        int resultIndex = 0;
        result[resultIndex] = max;
        for (int i = k; i < n; i++) {
            if (i - maxLocation + 1 > k) {
                // recount max
                max = nums[i];
                maxLocation = i;
                for (int j = 0; j < k; j++) {
                    if (nums[i - j] > max) {
                        max = nums[i - j];
                        maxLocation = i - j;
                    }
                }
            } else {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            resultIndex++;
            result[resultIndex] = max;
        }
        return result;
    }

    // 使用队列 Time Limit Exceeded
    private static int[] maxSlidingWindowMy2(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Queue<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
            queue.add(nums[i]);
        }
        int resultIndex = 0;
        result[resultIndex] = max;
        for (int i = k; i < n; i++) {
            int last = queue.poll();
            if (last == max) {
                // recountMax
                max = nums[i];
                for (int num : queue) {
                    max = Math.max(max, num);
                }
            } else {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            queue.add(nums[i]);
            resultIndex++;
            result[resultIndex] = max;
        }
        return result;
    }

    // Beats6.81%
    private static int[] maxSlidingWindowMy3(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        List<Integer> singleQueue = new ArrayList<>(); // 里面放最大值，只维护最大值后面的内容，最大值前面的内容不用维护，因为窗口移动的时候会删掉
        int resultIndex = 0;
        for (int i = 0; i < n; i++) {
            // 需要维持queue内部单调
            if (!singleQueue.isEmpty() && i - k + 1 > singleQueue.get(0)) {
                // 先把当前的删掉，当前可能是最大，最大的话会影响到后续
                singleQueue.remove(0);
            }
            while (!singleQueue.isEmpty() && nums[i] > nums[singleQueue.get(singleQueue.size() - 1)]) {
                // 然后判断，将比自己小的部分都去掉
                singleQueue.remove(singleQueue.size() - 1);
            }
            singleQueue.add(i);
            if (i >= k - 1) {
                result[resultIndex++] = nums[singleQueue.get(0)];
            }
        }
        return result;
    }

    // Beats42.34%
    private static int[] maxSlidingWindowAnswer1(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;
        // store index
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            // q contains index... r contains content
            queue.offer(i);
            if (i >= k - 1) {
                result[resultIndex++] = nums[queue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] tokensSet = new int[][]{
                {1, 3, 1, 2, 0, 5},
                {7, 2, 4},
                {1, -1},
                {1, 3, -1, -3, 5, 3, 6, 7},
                {1},
        };
        int[] kSet = new int[]{
                3,
                2,
                1,
                3,
                1,
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < tokensSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSlidingWindowMy1(tokensSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("maxSlidingWindow My1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < tokensSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSlidingWindowMy2(tokensSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("maxSlidingWindow My2 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < tokensSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSlidingWindowMy3(tokensSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("maxSlidingWindow My3 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < tokensSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxSlidingWindowAnswer1(tokensSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("maxSlidingWindow Answer1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

    }
}
