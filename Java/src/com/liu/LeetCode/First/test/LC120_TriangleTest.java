package com.liu.LeetCode.First.test;

import java.util.ArrayList;
import java.util.List;

import static com.liu.LeetCode.First.exercise.LC120_Triangle.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC120_TriangleTest {

    public static void main(String[] args) {
        int[][] input = new int[][]{
//                {2},
//                {3, 4},
//                {6, 5, 7},
//                {4, 1, 8, 3}
//                {-1},
//                {2, 3},
//                {1, -1, -3}
//                {-1},
//                {3, 2},
//                {-3, 1, -1}
                // 局部最优解
                {2},
                {3, 4},
                {6, 5, 9},
                {4, 4, 8, 0}
        };
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] list : input) {
            List<Integer> cache = new ArrayList<>();
            for (int i : list) {
                cache.add(i);
            }
            triangle.add(cache);
        }
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(triangle);
        endTime = System.currentTimeMillis();
        System.out.println("Triangle My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(triangle);
        endTime = System.currentTimeMillis();
        System.out.println("Triangle Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(List<List<Integer>> triangle) {
        return getTriangleMy1(triangle);
    }

    private static int testAnswer1(List<List<Integer>> triangle) {
        return getTriangleAnswer1(triangle);
    }
}
