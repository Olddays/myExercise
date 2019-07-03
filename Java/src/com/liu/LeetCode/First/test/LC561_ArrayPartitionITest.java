package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC561_ArrayPartitionI.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC561_ArrayPartitionITest {

    public static void main(String[] args) {
        int[] nums = {
                1, 4, 3, 2
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayPartitionI My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getArrayPartitionIMy1(nums);
    }
}
