package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC016_ThreeSumClosest.*;


/**
 * Created by liu on 2017/9/14.
 */
public class LC016_ThreeSumClosestTest {


    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, 2, 1, -4};
        int target = 1;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums1, target);
        endTime = System.currentTimeMillis();
        System.out.println("ThreeSumClosest My 1 " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums1, int target) {
        return getThreeSumClosestMy1(nums1, target);
    }

}
