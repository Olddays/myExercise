package com.liu.LeetApp.test;

import static com.liu.LeetApp.exercise.LA009_BestTimeToBuyAndSellStockII.*;

/**
 * Created by liu on 2016/12/6.
 */
public class LA009_BestTimeToBuyAndSellStockIITest {

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 22, 3, 4, 1, 9};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy3(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams My 3 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams answer result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return bestTimeToBuyAndSellStockIIMy1(input);
    }

    private static int testMy2(int[] input) {
        return bestTimeToBuyAndSellStockIIMy2(input);
    }

    private static int testMy3(int[] input) {
        return bestTimeToBuyAndSellStockIIMy3(input);
    }

    private static int testAnswer(int[] input) {
        return bestTimeToBuyAndSellStockIIAnswer(input);
    }
}
