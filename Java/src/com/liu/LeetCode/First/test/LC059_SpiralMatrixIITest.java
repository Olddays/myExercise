package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC059_SpiralMatrixII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC059_SpiralMatrixIITest {


    public static void main(String[] args) {
        int input = 3;
        int[][] result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("SpiralMatrixII My 1 result.size " + result.length + " during time " + (endTime - startTime));
        for (int[] row : result) {
            for (int li : row) {
                System.out.print(li + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] testMy1(int input) {
        return getSpiralMatrixIIMy1(input);
    }
}
