package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD29_BestTimeToBuyAndSellStockWithCooldown.maxProfit;
import static com.liu.LeetCode.ThirtyDays202007.exercise.TD29_BestTimeToBuyAndSellStockWithCooldown.maxProfitOptimize;

/**
 * Created by Liu on 2020/7/29.
 */
public class TD29_BestTimeToBuyAndSellStockWithCooldown_Test {
    public static void main(String[] args) {
        int[] prices;
        int result;
        long startTime;
        long endTime;


        prices = new int[]{
                1, 2, 3, 0, 2
        };
        startTime = System.currentTimeMillis();
        result = testMy1(prices);
        endTime = System.currentTimeMillis();
        System.out.println("TD29_BestTimeToBuyAndSellStockWithCooldown My 1 result: " + result + ", during time " + (endTime - startTime));

        prices = new int[]{
                1, 2, 3, 0, 2
        };
        startTime = System.currentTimeMillis();
        result = testOptimize(prices);
        endTime = System.currentTimeMillis();
        System.out.println("TD29_BestTimeToBuyAndSellStockWithCooldown Optimize 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[] prices) {
        return maxProfit(prices);
    }

    private static int testOptimize(int[] prices) {
        return maxProfitOptimize(prices);
    }
}
