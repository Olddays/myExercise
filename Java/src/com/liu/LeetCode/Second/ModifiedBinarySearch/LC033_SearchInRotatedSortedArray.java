package com.liu.LeetCode.Second.ModifiedBinarySearch;

public class LC033_SearchInRotatedSortedArray {
    // error, 无法处理（5，1，3）找3这种情况
    // 核心是缺少了mid和左右的比较
    private static int searchMy1(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[left] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int searchAnswer1(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) { // 说明mid的左半边是有序的
                if (nums[left] <= target && target < nums[mid]) {
                    // 左侧有序，并且左边小于target，并且target小于mid，所以左移
                    right = mid - 1;
                } else {
                    // 否则，只能是target大于了mid，要么是left大于mid，那么就得右移
                    left = mid + 1;
                }
            } else { // 说明mid的右半边是有序的
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {17, 11, 13, 15, 16},
                {5, 1, 3},
                {4, 5, 6, 7, 8, 1, 2},
                {4, 5, 6, 7, 0, 1, 2},
                {4, 5, 6, 7, 0, 1, 2},
                {1},
        };
        int[] targetSet = new int[]{
                11,
                3,
                8,
                0,
                3,
                0,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = searchMy1(numsSet[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("search My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = searchAnswer1(numsSet[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("search Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
