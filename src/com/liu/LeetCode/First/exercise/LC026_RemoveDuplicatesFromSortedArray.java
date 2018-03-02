package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/14.
 */
public class LC026_RemoveDuplicatesFromSortedArray {
    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * <p>
     * For example,
     * Given input array nums = [1,1,2],
     * <p>
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
     */


    // 有正确的返回值,没有整理nums
    public static int getRemoveDuplicatesFromSortedArrayMy1(int[] nums) {
        if (null == nums) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int resultLength = 1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] != nums[left + 1]) {
                resultLength++;
            }
            left++;
            if (nums[right] != nums[right - 1]) {
                resultLength++;
            }
            right--;
        }
        return resultLength;
    }

    public static int getRemoveDuplicatesFromSortedArrayAnswer1(int[] nums) {
        int index = 0;
        for (int n : nums) {
            if (index == 0 || n > nums[index - 1]) {
                nums[index] = n;
                index++;
            }
        }
        return index;
    }
}
