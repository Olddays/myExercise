package com.liu.LeetCode.Daily.Daily202503;

public class LC2401_LongestNiceSubarray {
    // 暴力解法，时间复杂度是N*logN
    // 题目理解有误，要找的是子集，不是有多少个组合
    private static int longestNiceSubarrayMyError1(int[] nums) {
        int length = nums.length;
        int count = 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // 滑动窗口，left到right之间进行计算
    // 时间复杂度是N*logN
    // “subarray” 中文释义为 “子数组”。在计算机编程中，子数组是一个数组中的一部分连续元素所组成的数组。例如，对于数组 [1,2,3,4,5]，[2,3,4] 就是一个子数组。
    // 子序列的话，就是从数组中挑选而不需要严格按照数组的顺序和内容
    public static int longestNiceSubarrayAnswer1(int[] nums) {
        int length = nums.length;
        int used = 0;
        int left = 0;
        int res = 0;
        for (int right = 0; right < length; ++right) {
            while ((used & nums[right]) != 0) {
                used ^= nums[left++]; // 类似于把left从used里面删除，并且往前移动，甚至可以理解为used-num[left]，只是使用了异或的操作
            }
            used |= nums[right]; // 将nums[right]放入used中，可以理解为used+num[right]，只是使用了或的操作
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    // Beats 98.64%
    // 这个题不难，核心是理解位运算
    public static int longestNiceSubarrayMy1(int[] nums) {
        int length = nums.length;
        int used = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < length) {
            if ((used & nums[right]) == 0) { // left前移
                result = Math.max(result, right - left + 1);
                used |= nums[right]; // 加入右
                right++;
            } else {
                used ^= nums[left]; // 删除左
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 3, 8, 48, 10},
                {3, 1, 5, 11, 13},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = longestNiceSubarrayMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("longestNiceSubarray My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = longestNiceSubarrayAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("longestNiceSubarray Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
