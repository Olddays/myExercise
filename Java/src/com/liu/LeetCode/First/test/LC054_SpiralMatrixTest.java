package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC054_SpiralMatrix.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC054_SpiralMatrixTest {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
//        int[][] nums = new int[][]{
//                {1}, {2}, {3},
//                {4}, {5}, {6},
//                {7}, {8}, {9}, {10}};
        List<Integer> result;
        long startTime;
        long endTime;

//        startTime = System.currentTimeMillis();
//        result = testMy1(nums);
//        endTime = System.currentTimeMillis();
//        System.out.println("SpiralMatrix My 1 result.size: " + result.size() + " during time " + (endTime - startTime));
//        for (int i : result) {
//            System.out.println("result: " + i);
//        }
//        System.out.println();
//
//        startTime = System.currentTimeMillis();
//        result = testMy2(nums);
//        endTime = System.currentTimeMillis();
//        System.out.println("SpiralMatrix My 2 result.size: " + result.size() + " during time " + (endTime - startTime));
//        for (int i : result) {
//            System.out.println("result: " + i);
//        }
//        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy3(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SpiralMatrix My 3 result.size: " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.println("result: " + i);
        }
        System.out.println();
    }

    private static List<Integer> testMy1(int[][] matrix) {
        return getSpiralMatrixMy1(matrix);
    }

    private static List<Integer> testMy2(int[][] matrix) {
        return getSpiralMatrixMy2(matrix);
    }

    private static List<Integer> testMy3(int[][] matrix) {
        return getSpiralMatrixMy3(matrix);
    }
}
