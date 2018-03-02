package com.liu.LeetApp.test;

import static com.liu.LeetApp.exercise.LA011_BestTimeToBuyAndSellStockIV.*;

/**
 * Created by liu on 2016/12/7.
 */
public class LA011_BestTimeToBuyAndSellStockIVTest {


    public static void main(String[] args) {
        int[] input = new int[]{20, 0, 1, 20, 22, 3, 4, 1, 9};
        int time = 1;
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
        result = testAnswer(input, time);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams answer result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return bestTimeToBuyAndSellStockIVMy1(input);
    }

    private static int testMy2(int[] input) {
        return bestTimeToBuyAndSellStockIVMy2(input);
    }

    private static int testAnswer(int[] input, int time) {
        return bestTimeToBuyAndSellStockIVAnswer(input, time);
    }
}
