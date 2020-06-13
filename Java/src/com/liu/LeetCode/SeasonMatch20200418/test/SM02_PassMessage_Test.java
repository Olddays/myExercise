package com.liu.LeetCode.SeasonMatch20200418.test;

import static com.liu.LeetCode.SeasonMatch20200418.exercise.SM02_PassMessage.numWays;

public class SM02_PassMessage_Test {

    public static void main(String[] args) {
        int n;
        int[][] relation;
        int k;

        int result;
        long startTime;
        long endTime;

        n = 5;
        relation = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        k = 3;

        startTime = System.currentTimeMillis();
        result = testMy1(n, relation, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_SingleNum My 1 result " + result + " during time " + (endTime - startTime));

        n = 3;
        relation = new int[][]{{0, 2}, {2, 1}};
        k = 2;

        startTime = System.currentTimeMillis();
        result = testMy1(n, relation, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_SingleNum My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int n, int[][] relation, int k) {
        return numWays(n, relation, k);
    }

}
