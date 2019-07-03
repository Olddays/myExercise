package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC454_4SumII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC454_4SumIITest {

    public static void main(String[] args) {
        int[][] As = {
                {1, 2}
        };
        int[][] Bs = {
                {-2, -1}
        };
        int[][] Cs = {
                {-1, 2}
        };
        int[][] Ds = {
                {0, 2}
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < As.length; i++) {
            int[] A = As[i];
            int[] B = Bs[i];
            int[] C = Cs[i];
            int[] D = Ds[i];

            startTime = System.currentTimeMillis();
            result = testAnswer1(A, B, C, D);
            endTime = System.currentTimeMillis();
            System.out.println("4SumII Answer 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testAnswer1(int[] A, int[] B, int[] C, int[] D) {
        return get4SumIIAnswer1(A, B, C, D);
    }
}
