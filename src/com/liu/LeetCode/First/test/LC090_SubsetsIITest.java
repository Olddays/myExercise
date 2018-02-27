package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC090_SubsetsII.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC090_SubsetsIITest {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 2
        };
        long startTime;
        List<List<Integer>> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SubsetsII My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<List<Integer>> testMy1(int[] nums) {
        return getSubsetsIIMy1(nums);
    }
}
