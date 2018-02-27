package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC189_RotateArray {
    /**
     * Rotate an array of n elements to the right by k steps.
     * <p>
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     * <p>
     * Note:
     * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     * <p>
     * [show hint]
     * <p>
     * Related problem: Reverse Words in a String II
     * <p>
     * Credits:
     * Special thanks to @Freezen for adding this problem and creating all test cases.
     */

    // 没有考虑k > nums.length的情况
    public static void getRotateArrayMy1(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        int target = length - k;
        for (int i = 0; i < target; i++) {
            for (int j = 1; j < length; j++) {
                int cache = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = cache;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // 时间复杂度最差为O(n²)果然还是太高了啊
    public static void getRotateArrayMy2(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        int target = length - (k % length);
        for (int i = 0; i < target; i++) {
            for (int j = 1; j < length; j++) {
                int cache = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = cache;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // The basic idea is that, for example, nums = [1,2,3,4,5,6,7] and k = 3, first we reverse [1,2,3,4],
    // it becomes[4,3,2,1]; then we reverse[5,6,7], it becomes[7,6,5], finally we reverse the array as a whole,
    // it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].
    // Reverse is done by using two pointers, one point at the head and the other point at the tail,
    // after switch these two, these two pointers move one position towards the middle.
    public static void getRotateArrayAnswer1(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
