package com.liu.LeetApp.test;

import static com.liu.LeetApp.exercise.LA010_BestTimeToBuyAndSellStockIII.*;

/**
 * Created by baidu on 2016/12/6.
 */
public class LA010_BestTimeToBuyAndSellStockIIITest {

    public static void main(String[] args) {
        int[] input = new int[]{22, 0, 1, 20, 22, 3, 4, 1, 9};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams answer result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return bestTimeToBuyAndSellStockIIIMy1(input);
    }

    private static int testAnswer(int[] input) {
        return bestTimeToBuyAndSellStockIIIAnswer(input);
    }
}
