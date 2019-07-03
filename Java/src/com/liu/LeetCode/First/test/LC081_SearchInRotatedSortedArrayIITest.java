package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC081_SearchInRotatedSortedArrayII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC081_SearchInRotatedSortedArrayIITest {

    public static void main(String[] args) {
        int[] nums = new int[]{
                0, 1, 2, 4, 5, 6, 7,
        };
        int target = 3;
        boolean result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("SearchInRotatedSortedArrayII My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(int[] nums, int target) {
        return getSearchInRotatedSortedArrayIIMy1(nums, target);
    }
}
