package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC119_PascalsTriangleII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC119_PascalsTriangleIITest {

    public static void main(String[] args) {
        int row = 6;
        long startTime;
        List<Integer> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(row);
        endTime = System.currentTimeMillis();
        System.out.println("PascalsTriangleII My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer2(row);
        endTime = System.currentTimeMillis();
        System.out.println("PascalsTriangleII Answer 2 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> testMy1(int row) {
        return getPascalsTriangleIIMy1(row);
    }

    private static List<Integer> testAnswer2(int row) {
        return getPascalsTriangleIIAnswer1(row);
    }
}
