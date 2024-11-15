package com.liu.LeetCode.Second.test;

import java.util.List;

import static com.liu.LeetCode.Second.exercise.LC054_SpiralMatrix.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC054_SpiralMatrixTest {

    public static void main(String[] args) {
        int[][][] numsList = new int[][][]{
                {
                    {1}, {2}, {3},
                    {4}, {5}, {6},
                    {7}, {8}, {9}, {10}
                }, {
                    {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                },
        };

        List<Integer> result;
        long startTime;
        long endTime;

        for (int[][] nums : numsList) {
            startTime = System.currentTimeMillis();
            result = testMy1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("SpiralMatrix My 1 result.size: " + result.size() + " during time " + (endTime - startTime));
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> testMy1(int[][] matrix) {
        return spiralOrderMy1(matrix);
    }
}
