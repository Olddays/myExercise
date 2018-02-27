package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC216_CombinationSumIII.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC216_CombinationSumIIITest {

    public static void main(String[] args) {
        int key = 3;
        int length = 7;
//        int key = 3;
//        int length = 9;
        long startTime;
        List<List<Integer>> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(key, length);
        endTime = System.currentTimeMillis();
        System.out.println("CombinationSumIII My 1 result.size " + result.size() + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> testMy1(int key, int length) {
        return getCombinationSumIIIMy1(key, length);
    }
}
