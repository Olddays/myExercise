package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC718_MaximumLengthOfRepeatedSubarray.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC718_MaximumLengthOfRepeatedSubarrayTest {

    public static void main(String[] args) {
        int[] A = {
                1, 2, 3, 2, 1
        };
        int[] B = {
                3, 2, 1, 4, 7
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(A, B);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumLengthOfRepeatedSubarray Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(A, B);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumLengthOfRepeatedSubarray Answer 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testAnswer1(int[] A, int[] B) {
        return getMaximumLengthOfRepeatedSubarrayAnswer1(A, B);
    }

    private static int testAnswer2(int[] A, int[] B) {
        return getMaximumLengthOfRepeatedSubarrayAnswer2(A, B);
    }
}
