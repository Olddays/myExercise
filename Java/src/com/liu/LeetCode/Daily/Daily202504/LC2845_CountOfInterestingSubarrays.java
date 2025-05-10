package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC2845_CountOfInterestingSubarrays {
    // 是否有单调性，决定了是否可以用双指针滑动窗口，或者得两层for
    // 如果双指针滑动窗口逐步向右遍历，发现左侧是可以不用再关注了的，那就可以用双指针滑动窗口
    // 否则就得使用两层for循环
    // Beats 85.32%
    private static long countInterestingSubarraysMy1(List<Integer> nums, int modulo, int k) {
        int length = nums.size();
        // 我们可以不用在一nums的具体值，只要知道是不是%modulo=k即可
        int[] cache = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums.get(i) % modulo == k) {
                cache[i] = 1;
            }
        }
        long result = 0;
        int count = 0;
        // 会涉及到回溯，比如modulo=3,k=0数组为（3，1，3，1，3，1，3，1）
        // 此时有0个、3个3的情况都得算
        // 经过上述转化，新数组为(0,1,0,1,0,1,0,1)，此时只关心1的数量是否%modulo=k即可
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : cache) {
            count = (count + num) % modulo;
            result += map.getOrDefault((count - k + modulo) % modulo, 0);
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {3, 4, 2},
                {3, 1, 9, 6},
        };
        int[] moduloList = new int[]{
                2,
                3,
        };
        int[] kList = new int[]{
                1,
                0,
        };
        long[] resultList = new long[]{
                3,
                2,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int num : numsList[i]) {
                nums.add(num);
            }
            startTime = System.currentTimeMillis();
            result = countInterestingSubarraysMy1(nums, moduloList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countInterestingSubarrays My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
