package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC169_MajorityElement.getMajorityElementMy1;

/**
 * Created by liu on 2017/9/14.
 */
public class LC169_MajorityElementTest {

    public static void main(String[] args) {
        int[] input = new int[]{
                2, 7, 11, 15
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("MajorityElement My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return getMajorityElementMy1(input);
    }
}
