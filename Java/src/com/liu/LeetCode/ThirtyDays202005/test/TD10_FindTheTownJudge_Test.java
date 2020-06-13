package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD10_FindTheTownJudge.findJudge;

/**
 * Created by Liu on 2020/5/10.
 */
public class TD10_FindTheTownJudge_Test {
    public static void main(String[] args) {
        int N;
        int[][] trust;
        int result;
        long startTime;
        long endTime;

        N = 11;
        trust = new int[][]{{1, 8}, {1, 3}, {2, 8}, {2, 3}, {4, 8}, {4, 3}, {5, 8}, {5, 3}, {6, 8}, {6, 3}, {7, 8}, {7, 3}, {9, 8}, {9, 3}, {11, 8}, {11, 3}};
        startTime = System.currentTimeMillis();
        result = testMy1(N, trust);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_FindTheTownJudge My 1 result " + result + " during time " + (endTime - startTime));

        N = 2;
        trust = new int[][]{{1, 2}};
        startTime = System.currentTimeMillis();
        result = testMy1(N, trust);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_FindTheTownJudge My 1 result " + result + " during time " + (endTime - startTime));

        N = 3;
        trust = new int[][]{{1, 3}, {2, 3}};
        startTime = System.currentTimeMillis();
        result = testMy1(N, trust);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_FindTheTownJudge My 1 result " + result + " during time " + (endTime - startTime));

        N = 3;
        trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        startTime = System.currentTimeMillis();
        result = testMy1(N, trust);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_FindTheTownJudge My 1 result " + result + " during time " + (endTime - startTime));

        N = 3;
        trust = new int[][]{{1, 2}, {2, 3}};
        startTime = System.currentTimeMillis();
        result = testMy1(N, trust);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_FindTheTownJudge My 1 result " + result + " during time " + (endTime - startTime));

        N = 4;
        trust = new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        startTime = System.currentTimeMillis();
        result = testMy1(N, trust);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_FindTheTownJudge My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static int testMy1(int N, int[][] trust) {
        return findJudge(N, trust);
    }

}
