package com.liu.LeetCode.CodeCaprice.Array;

public class LC704_BinarySearch {
    // 核心是看开闭情况，如果双闭，那么while的left<=right，否则left<right
    // 哪边闭，哪边就得在middle基础上进行+-1，左+右-
    // middle的计算，是left和right中间，所以不需要right+1，
    // 另外，left+right可能溢出，所以还是left + (right - left) / 2;
    // right的赋值，在左闭右闭时，right=length-1，因为右闭包含
    // 而左闭右开时，right=length，因为右开不包含
    // 所以不能左开右闭，0得包含

    // 左闭右闭
    private static int searchMy1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        // 左闭右闭，所以可以相等
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1; // 已经查过边界middle，不包含
            } else {
                right = middle - 1; // 已经查过边界middle，不包含
            }
        }
        return -1;
    }

    // 左闭右开
    private static int searchMy2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int middle;
        // 左闭右开，所以不可以相等
        while (left < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {-1, 0, 3, 5, 9, 12},
                {-1, 0, 3, 5, 9, 12},
        };
        int[] targetList = new int[]{
                9,
                2,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = searchMy1(numsList[i], targetList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("search My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = searchMy2(numsList[i], targetList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("search My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
