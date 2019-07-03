package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC062_UniquePaths.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC062_UniquePathsTest {


    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(m, n);
        endTime = System.currentTimeMillis();
        System.out.println("UniquePaths My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int m, int n) {
        return getUniquePathsMy1(m, n);
    }
}
