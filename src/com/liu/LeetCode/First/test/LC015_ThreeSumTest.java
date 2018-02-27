package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC015_ThreeSum.*;


/**
 * Created by baidu on 2017/9/14.
 */
public class LC015_ThreeSumTest {


    public static void main(String[] args) {
        int[] nums1 = new int[]{-2, 0, 1, 1, 2};
        List<List<Integer>> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums1);
        endTime = System.currentTimeMillis();
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            System.out.println("FourSum My 1 result i " + i
                    + " list " + list.get(0)
                    + " " + list.get(1)
                    + " " + list.get(2)
                    + " during time " + (endTime - startTime));
        }
    }

    private static List<List<Integer>> testMy1(int[] nums1) {
        return getThreeSumMy1(nums1);
    }

}
