package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC714_BestTimeToBuyAndSellStockWithTransactionFee.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC714_BestTimeToBuyAndSellStockWithTransactionFeeTest {

    public static void main(String[] args) {
        int[] prices = {
                1, 3, 2, 8, 4, 9
//                1, 5, 9
        };
        int fee = 2;
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(prices, fee);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockWithTransactionFee My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(prices, fee);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockWithTransactionFee My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(prices, fee);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockWithTransactionFee Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(prices, fee);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockWithTransactionFee Answer 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] prices, int fee) {
        return getBestTimeToBuyAndSellStockWithTransactionFeeMy1(prices, fee);
    }

    private static int testMy2(int[] prices, int fee) {
        return getBestTimeToBuyAndSellStockWithTransactionFeeMy2(prices, fee);
    }

    private static int testAnswer1(int[] prices, int fee) {
        return getBestTimeToBuyAndSellStockWithTransactionFeeAnswer1(prices, fee);
    }

    private static int testAnswer2(int[] prices, int fee) {
        return getBestTimeToBuyAndSellStockWithTransactionFeeAnswer2(prices, fee);
    }
}
