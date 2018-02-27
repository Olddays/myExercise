package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC414_ThirdMaximumNumber.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC414_ThirdMaximumNumberTest {

    public static void main(String[] args) {
        int[] nums = {
                2, 2, 3, 1
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("ThirdMaximumNumber Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testAnswer1(int[] nums) {
        return getThirdMaximumNumberAnswer1(nums);
    }
}
