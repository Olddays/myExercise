package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC188_BestTimeToBuyAndSellStockIV.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC188_BestTimeToBuyAndSellStockIVTest {

    public static void main(String[] args) {
        int k = 3;
        int[] prices = new int[]{
                1, 2, 3, 4, 5, 6, 7
        };
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(k, prices);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockIV My 1 during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        testAnswer1(k, prices);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockIV Answer 1 during time " + (endTime - startTime));
    }

    private static void testMy1(int k, int[] prices) {
        getBestTimeToBuyAndSellStockIVMy1(k, prices);
    }

    private static void testAnswer1(int k, int[] prices) {
        getBestTimeToBuyAndSellStockIVAnswer1(k, prices);
    }
}
