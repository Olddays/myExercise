package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC004_MedianOfTwoSortedArrays.*;

/**
 * Created by baidu on 2017/9/7.
 */
public class LC004_MedianOfTwoSortedArraysTest {

    /**
     * 特殊输入:
     * [],[1]
     * [],[1, 2]
     * [1],[2, 3]
     * [1, 3],[2]
     * [1, 1],[1, 2]
     * [1, 2, 3, 4],[3, 4, 5]
     * 重点是要求时间复杂度为O(log(n+m))即意味着必须进行二分法查找
     * 如果时间复杂度要求为O(m+n)则直接使用Map即可
     * <p>
     * http://bangbingsyb.blogspot.com/2014/11/leetcode-median-of-two-sorted-arrays.html
     * http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
     * http://www.cnblogs.com/springfor/p/3861890.html
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double result;
        long startTime;
        long endTime;

//        startTime = System.currentTimeMillis();
//        result = testMy1(nums1, nums2);
//        endTime = System.currentTimeMillis();
//        System.out.println("getMedianOfTwoSortedArrays My 1 result " + result + " during time " + (endTime - startTime));
//
//        startTime = System.currentTimeMillis();
//        result = testMy2(nums1, nums2);
//        endTime = System.currentTimeMillis();
//        System.out.println("getMedianOfTwoSortedArrays My 2 result " + result + " during time " + (endTime - startTime));
//
//        startTime = System.currentTimeMillis();
//        result = testMy3(nums1, nums2);
//        endTime = System.currentTimeMillis();
//        System.out.println("getMedianOfTwoSortedArrays My 3 result " + result + " during time " + (endTime - startTime));
//
//        startTime = System.currentTimeMillis();
//        result = testMy4(nums1, nums2);
//        endTime = System.currentTimeMillis();
//        System.out.println("getMedianOfTwoSortedArrays My 4 result " + result + " during time " + (endTime - startTime));

//        startTime = System.currentTimeMillis();
//        result = testMy5(nums1, nums2);
//        endTime = System.currentTimeMillis();
//        System.out.println("getMedianOfTwoSortedArrays My 5 result " + result + " during time " + (endTime - startTime));
//
//        startTime = System.currentTimeMillis();
//        result = testMy6(nums1, nums2);
//        endTime = System.currentTimeMillis();
//        System.out.println("getMedianOfTwoSortedArrays My 6 result " + result + " during time " + (endTime - startTime));
//
//        startTime = System.currentTimeMillis();
//        result = testMy7(nums1, nums2);
//        endTime = System.currentTimeMillis();
//        System.out.println("getMedianOfTwoSortedArrays My 7 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums1, nums2);
        endTime = System.currentTimeMillis();
        System.out.println("getMedianOfTwoSortedArrays Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static double testMy1(int[] nums1, int[] nums2) {
        return getMedianOfTwoSortedArraysMy1(nums1, nums2);
    }

    private static double testMy2(int[] nums1, int[] nums2) {
        return getMedianOfTwoSortedArraysMy2(nums1, nums2);
    }

    private static double testMy3(int[] nums1, int[] nums2) {
        return getMedianOfTwoSortedArraysMy3(nums1, nums2);
    }

    private static double testMy4(int[] nums1, int[] nums2) {
        return getMedianOfTwoSortedArraysMy4(nums1, nums2);
    }

    private static double testMy5(int[] nums1, int[] nums2) {
        return getMedianOfTwoSortedArraysMy5(nums1, nums2);
    }

    private static double testMy6(int[] nums1, int[] nums2) {
        return getMedianOfTwoSortedArraysMy6(nums1, nums2);
    }

    private static double testMy7(int[] nums1, int[] nums2) {
        return getMedianOfTwoSortedArraysMy7(nums1, nums2);
    }

    private static double testAnswer1(int[] nums1, int[] nums2) {
        return getMedianOfTwoSortedArraysAnswer1(nums1, nums2);
    }
}
