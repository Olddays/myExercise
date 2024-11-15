package com.liu.LeetCode.FifteenPatterns.ModifiedBinarySearch;

public class LC153_FindMinimumInRotatedSortedArray {

    // error,无法处理{17, 11, 13, 15, 16},
    private static int findMinMy1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right + 1 - left) / 2;
            result = Math.min(result, nums[mid]);
            if (nums[left] < nums[mid]) {
                if (nums[right] < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[right] < nums[left]) {
                    // 在这里，抛弃了{17, 11, 13, 15, 16}中的17和11
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }

    // 核心，哪小往哪里找
    private static int findMinMy2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            result = Math.min(result, nums[mid]);
            if (nums[left] <= nums[mid]) { // 中间大于左边
                if (nums[left] < nums[right]) { // 右边大于左边
                    right = mid - 1; // 左边最小，缩右边
                } else {
                    left = mid + 1;
                }
            } else { // 中间小于左边
                // if (nums[right] > nums[left]) {  // 左边小于右边，是不可能的
                right = mid - 1;
            }
        }
        return result;
    }

    private static int findMinAnswer1(int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[left] <= nums[mid] && nums[mid] >= nums[right]) {
                result = Math.min(result, nums[left]);
                left = mid + 1;
            } else {
                result = Math.min(result, nums[mid]);
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {17, 11, 13, 15, 16},
                {3, 4, 5, 1, 2},
                {4, 5, 6, 7, 0, 1, 2},
                {5, 6, 7, 0, 1, 2, 4},
                {11, 13, 15, 17},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findMinMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findMin My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findMinMy2(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findMin My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findMinAnswer1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findMin Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
