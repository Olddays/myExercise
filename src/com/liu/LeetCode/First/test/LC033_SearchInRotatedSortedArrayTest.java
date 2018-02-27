package com.liu.LeetCode.First.test;


import static com.liu.LeetCode.First.exercise.LC033_SearchInRotatedSortedArray.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC033_SearchInRotatedSortedArrayTest {


    public static void main(String[] args) {
        int[] nums = new int[]{6, 5, 4, 8, 7, 5, 1};
        int target = 0;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("SearchInRotatedSortedArray My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int target) {
        return getSearchInRotatedSortedArrayMy1(nums, target);
    }
}
