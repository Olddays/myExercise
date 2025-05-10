package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC2444_CountSubarraysWithFixedBounds {

    // 寻找子数组的问题，一般都是用双指针（滑动窗口）
    // 跟2845比较像，可以把题目可用和不可用的信息
    // 转化为，最大值为max的数组数量，减去最大值为min-1的数组数量
    // case1 可以转化为三个标记，maxk为1，大于maxk为-1，其他为0
    // case2 可以转化为三个标记，mink-1为1，大于mink-1为-1，其他为0
    // case1-case2
    // Error,无法确保再max中有min
    private static long countSubarraysMyError1(int[] nums, int minK, int maxK) {
        int length = nums.length;
        int[] cacheMax = new int[length];
        int[] cacheMin = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums[i] == minK - 1) {
                cacheMin[i] = 1;
            } else if (nums[i] > minK - 1) {
                cacheMax[i] = -1;
            }
            if (nums[i] == maxK) {
                cacheMax[i] = 1;
            } else if (nums[i] > maxK) {
                cacheMax[i] = -1;
            }
        }
        long maxCount = countSubarraysMy1Helper(cacheMax);
        long minCount = countSubarraysMy1Helper(cacheMin);
        return maxCount - minCount;
    }

    private static long countSubarraysMy1Helper(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        long result = 0;
        boolean hasOne = false;
        while (right < length) {
            if (nums[right] == -1) {
                left = right + 1;
                hasOne = false;
                right++;
            } else {
                if (nums[right] == 1) {
                    hasOne = true;
                }
                if (!hasOne) {
                    result += (long) (right - left + 1) * (right - left) / 2;
                }
                right++;
            }
        }
        return result;
    }

    // Brute Force Time Limit Exceeded
    private static long countSubarraysMyError2(int[] nums, int minK, int maxK) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                mini = Math.min(mini, nums[j]);
                maxi = Math.max(maxi, nums[j]);
                if (mini == minK && maxi == maxK) {
                    count++;
                }
            }
        }
        return count;
    }

    // 使用dequeue来存储最大值和最小值的索引
    // Beats 5.04%
    private static long countSubarraysAnswer1(int[] nums, int minK, int maxK) {
        long count = 0;
        int left = 0;
        Deque<Integer> dqMin = new ArrayDeque<>();
        Deque<Integer> dqMax = new ArrayDeque<>();

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) { // 出现越界数据，直接清空重新算
                dqMin.clear();
                dqMax.clear();
                left = i + 1;
                continue;
            }
            // min队列，如果发现当前值小于min队列的最后一个值，就把最后一个值弹出
            // 这样可以确保min队列的第一个值是最小的
            // max队列同理
            while (!dqMin.isEmpty() && nums[dqMin.peekLast()] >= nums[i]) {
                dqMin.pollLast();
            }
            dqMin.offerLast(i);
            while (!dqMax.isEmpty() && nums[dqMax.peekLast()] <= nums[i]) {
                dqMax.pollLast();
            }
            dqMax.offerLast(i);
            // 如果min队列和max队列的第一个值都是minK和maxK，就说明找到了一个符合条件的子数组
            // 此时，我们需要计算这个子数组的长度
            // 子数组的长度 = min(dqMin.peekFirst(), dqMax.peekFirst()) - left + 1
            // 为什么是min(dqMin.peekFirst(), dqMax.peekFirst())呢？
            // 因为我们是从左到右遍历的，所以min(dqMin.peekFirst(), dqMax.peekFirst())就是这个子数组的最左边的索引
            // 为什么是left呢？
            // 因为left是我们的左边界，我们需要确保这个子数组的最左边的索引在left的右边
            // 这样才能保证这个子数组是符合条件的
            // 为什么是dqMin.peekFirst()和dqMax.peekFirst()呢？
            // 因为我们的min队列和max队列的第一个值都是minK和maxK，所以我们需要计算这个子数组的长度
            // 这个子数组的长度 = min(dqMin.peekFirst(), dqMax.peekFirst()) - left + 1
            // 为什么是min(dqMin.peekFirst(), dqMax.peekFirst())呢？
            // 因为我们的min队列和max队列的第一个值都是minK和maxK，所以我们需要计算这个子数组的长度
            // 这个子数组的长度 = min(dqMin.peekFirst(), dqMax.peekFirst()) - left + 1
            if (nums[dqMin.peekFirst()] == minK && nums[dqMax.peekFirst()] == maxK) {
                int start = Math.min(dqMin.peekFirst(), dqMax.peekFirst());
                count += (start - left + 1);
            }
        }
        return count;
    }

    // 滑动窗口
    // Beats 95.85%
    private static long countSubarraysAnswer2(int[] nums, int minK, int maxK) {
        long count = 0;
        int start = -1; // 位置标记
        int minI = -1; // 位置标记
        int maxI = -1; // 位置标记
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                start = i; // 如果越界，那就更新起点
            }
            if (nums[i] == maxK) { // 记录最大的位置
                maxI = i;
            }
            if (nums[i] == minK) { // 记录最小的位置
                minI = i;
            }
            int valid = Math.max(0, Math.min(minI, maxI) - start); // 用max，因为maxI和minI都是位置标记，所以可能为-1
            count += valid;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 3, 5, 2, 7, 5},
                {1, 1, 1, 1},
        };
        int[] minKList = new int[]{
                1,
                1,
        };
        int[] maxKList = new int[]{
                5,
                1,
        };
        long[] resultList = new long[]{
                2,
                10,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countSubarraysAnswer1(numsList[i], minKList[i], maxKList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countSubarrays Answer1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countSubarraysAnswer2(numsList[i], minKList[i], maxKList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countSubarrays Answer2 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
