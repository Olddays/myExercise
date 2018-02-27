package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC075_SortColors {
    /**
     * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     * <p>
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * <p>
     * Note:
     * You are not suppose to use the library's sort function for this problem.
     * <p>
     * Follow up:
     * A rather straight forward solution is a two-pass algorithm using counting sort.
     * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     * <p>
     * Could you come up with an one-pass algorithm using only constant space?
     */

    // 思路错了,在[0,0,1,1,2,2,0,0,1,1,2,2]的情况下无法处理
    public static void getSortColorsMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int leftNum = nums[left];
            if (leftNum == 1) {
                nums[left] = nums[left + 1];
                nums[left + 1] = leftNum;
            } else if (leftNum == 2) {
                nums[left] = nums[right];
                nums[right] = leftNum;
            } else {
                left++;
            }
            int rightNum = nums[right];
            if (rightNum == 0) {
                nums[right] = nums[left];
                nums[left] = rightNum;
            } else if (rightNum == 1) {
                nums[right] = nums[right - 1];
                nums[right - 1] = rightNum;
            } else {
                right--;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // 分开处理,先移动0,再移动2
    public static void getSortColorsMy2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        int zeroSize = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) { // red
                int cache = nums[i];
                nums[i] = nums[zeroSize];
                nums[zeroSize] = cache;
                zeroSize++;
            }
        }
        int twoSize = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] == 2) { // blue
                int cache = nums[i];
                nums[i] = nums[twoSize];
                nums[twoSize] = cache;
                twoSize--;
            } else if (nums[i] == 0) {
                // 可以规避掉已经处理过的0(red)的部分
                break;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
