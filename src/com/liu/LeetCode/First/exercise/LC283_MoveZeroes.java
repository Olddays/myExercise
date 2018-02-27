package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC283_MoveZeroes {
    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     * <p>
     * Note:
     * <p>
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */

    public static void getMoveZeroesMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            int cache = i;
            while (i < length && nums[i] == 0) {
                i++;
            }
            if (i < length) { // 这样写 超级丑..
                int cacheNum = nums[cache];
                nums[cache] = nums[i];
                nums[i] = cacheNum;
                i = cache;
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    // 操 真巧妙
    public static void getMoveZeroesAnswer1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
