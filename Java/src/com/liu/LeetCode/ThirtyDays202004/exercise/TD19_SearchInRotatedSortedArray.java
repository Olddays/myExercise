package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD19_SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left < right && nums[left] > target) {
            left++;
        }
        while (left < right && nums[right] < target) {
            right--;
        }
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            }
        }
        return -1;
    }
}
