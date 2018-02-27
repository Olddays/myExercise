package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC485_MaxConsecutiveOnes.getMaxConsecutiveOnesMy1;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC485_MaxConsecutiveOnesTest {

    public static void main(String[] args) {
        int[] nums = {
                1, 1, 0, 1, 1, 1
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MaxConsecutiveOnes My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getMaxConsecutiveOnesMy1(nums);
    }
}
