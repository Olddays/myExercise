package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC018_FourSum.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC018_FourSumTest {


    public static void main(String[] args) {
        int[] nums1 = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        List<List<Integer>> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums1, target);
        endTime = System.currentTimeMillis();
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            System.out.println("FourSum My 1 result i " + i
                    + " list " + list.get(0)
                    + " " + list.get(1)
                    + " " + list.get(2)
                    + " " + list.get(3)
                    + " during time " + (endTime - startTime));
        }
    }

    private static List<List<Integer>> testMy1(int[] nums1, int target) {
        return getFourSumMy1(nums1, target);
    }

}
