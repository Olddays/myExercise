package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC088_MergeSortedArray {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note:
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
     */

    public static void getMergeSortedArrayMy1(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        } else if (n > 0) {
            for (int i = m; i < m + n; i++) {
                nums1[i] = nums2[i - m];
            }
            Arrays.sort(nums1);
        }
        for (int s : nums1) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
