package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC350_IntersectionOfTwoArraysII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC350_IntersectionOfTwoArraysIITest {

    public static void main(String[] args) {
        int[][] num1Set = {
                {1, 2, 2, 1},
                {1, 2},
                {1, 1}
        };
        int[][] num2Set = {
                {2, 2},
                {1, 1},
                {1, 2}
        };
        long startTime;
        int[] result;
        long endTime;

        for (int i = 0; i < num1Set.length; i++) {
            int[] nums1 = num1Set[i];
            int[] nums2 = num2Set[i];

            startTime = System.currentTimeMillis();
            result = testMy1(nums1, nums2);
            endTime = System.currentTimeMillis();
            System.out.println("IntersectionOfTwoArraysII My 1 result.length " + result.length + " during time " + (endTime - startTime));
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[] testMy1(int[] nums1, int[] nums2) {
        return getIntersectionOfTwoArraysIIMy1(nums1, nums2);
    }
}
