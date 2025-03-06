package com.liu.LeetCode.Daily.Daily202503;

public class LC2161_PartitionArrayAccordingToGivenPivot {

    // Beats 85.39%
    private static int[] pivotArrayMy1(int[] nums, int pivot) {
        int length = nums.length;
        int[] result = new int[length];
        int left = 0;
        int right = length - 1;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < pivot) {
                result[left] = nums[i];
                left++;
            }
            if (nums[i] == pivot) {
                count++;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] > pivot) {
                result[right] = nums[i];
                right--;
            }
        }
        while (count > 0) {
            result[left] = pivot;
            left++;
            count--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums1List = new int[][]{
                {9, 12, 5, 10, 14, 3, 10},
                {-3, 4, 3, 2},
        };
        int[] pivotList = new int[]{
                10,
                2,
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = pivotArrayMy1(nums1List[i], pivotList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("mergeArrays My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
