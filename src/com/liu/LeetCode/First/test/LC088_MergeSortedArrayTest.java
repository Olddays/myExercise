package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC088_MergeSortedArray.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC088_MergeSortedArrayTest {

    public static void main(String[] args) {
        int[] nums1 = new int[]{
//                1, 4, 7, 0, 0, 0
//                0
                4, 0, 0, 0, 0, 0
        };
        int[] nums2 = new int[]{
//                2, 5, 8
//                1
                1, 2, 3, 5, 6
        };
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(nums1, nums2);
        endTime = System.currentTimeMillis();
        System.out.println("MergeSortedArray My 1 during time " + (endTime - startTime));
    }

    private static void testMy1(int[] nums1, int[] nums2) {
        getMergeSortedArrayMy1(nums1, nums1.length - nums2.length, nums2, nums2.length);
    }
}
