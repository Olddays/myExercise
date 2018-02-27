package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC309_BestTimeToBuyAndSellStockWithCooldown.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC309_BestTimeToBuyAndSellStockWithCooldownTest {

    public static void main(String[] args) {
        int[] prices = {
                1, 2, 3, 0, 2
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(prices);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockWithCooldown My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(prices);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockWithCooldown Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] prices) {
        return getBestTimeToBuyAndSellStockWithCooldownMy1(prices);
    }

    private static int testAnswer1(int[] prices) {
        return getBestTimeToBuyAndSellStockWithCooldownAnswer1(prices);
    }
}
