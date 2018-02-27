package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC080_RemoveDuplicatesFromSortedArrayII {
    /**
     * Follow up for "Remove Duplicates":
     * What if duplicates are allowed at most twice?
     * <p>
     * For example,
     * Given sorted array nums = [1,1,1,2,2,3],
     * <p>
     * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
     */

    public static int getRemoveDuplicatesFromSortedArrayIIMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int result = 0;
        for (int n : nums) {
            // 前两个直接加入,然后当前值大于两个前的值
            if (result < 2 || n > nums[result - 2]) {
                nums[result++] = n;
            }
        }
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
        return result;
    }
}
