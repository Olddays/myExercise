package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC118_PascalsTriangle.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC118_PascalsTriangleTest {

    public static void main(String[] args) {
        int row = 9;
        long startTime;
        List<List<Integer>> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(row);
        endTime = System.currentTimeMillis();
        System.out.println("PascalsTriangle My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        goThroughResult(result);
        System.out.println();
    }

    private static List<List<Integer>> testMy1(int row) {
        return getPascalsTriangleMy1(row);
    }

    private static void goThroughResult(List<List<Integer>> result) {
        if (result != null) {
            for (List<Integer> list : result) {
                for (int i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}
