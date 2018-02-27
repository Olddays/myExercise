package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC085_MaximalRectangle.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC085_MaximalRectangleTest {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("MaximalRectangle Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(matrix);
        endTime = System.currentTimeMillis();
        System.out.println("MaximalRectangle Answer 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testAnswer1(char[][] nums) {
        return getMaximalRectangleAnswer1(nums);
    }

    private static int testAnswer2(char[][] nums) {
        return getMaximalRectangleAnswer2(nums);
    }
}
