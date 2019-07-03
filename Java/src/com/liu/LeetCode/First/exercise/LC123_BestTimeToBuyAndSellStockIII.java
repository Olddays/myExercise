package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC123_BestTimeToBuyAndSellStockIII {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * <p>
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */

    // 无法处理[3, 3, 5, 0, 0, 3, 1, 4]这种,最后两个值相比后者大的情况
    public static int getBestTimeToBuyAndSellStockIIIMy1(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int result = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            if (count > 2) {
                break;
            }
            min = Math.min(min, prices[i - 1]);
            if (prices[i] < prices[i - 1]) {
                result += (prices[i - 1] - min);
                count++;
                min = prices[i];
            }
        }
        // 用以规避输入[1,2]的情况
        if (prices[length - 1] > min) {
            result += prices[length - 1] - min;
        }
        return result;
    }

    // The thinking is simple and is inspired by the best solution from Single Number II (I read through the discussion after I use DP).
    // Assume we only have 0 money at first;
    // 4 Variables to maintain some interested 'ceilings' so far:
    // The maximum of if we've just buy 1st stock, if we've just sold 1nd stock, if we've just buy 2nd stock, if we've just sold 2nd stock.
    // Very simple code too and work well. I have to say the logic is simple than those in Single Number II.
    public static int getBestTimeToBuyAndSellStockIIIAnswer1(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE;
        int firstSell = 0, secondSell = 0;
        for (int i : prices) {                              // Assume we only have 0 money at first
            secondSell = Math.max(secondSell, secondBuy + i);     // The maximum if we've just sold 2nd stock so far.
            secondBuy = Math.max(secondBuy, firstSell - i);  // The maximum if we've just buy  2nd stock so far.
            firstSell = Math.max(firstSell, firstBuy + i);     // The maximum if we've just sold 1nd stock so far.
            firstBuy = Math.max(firstBuy, -i);          // The maximum if we've just buy  1st stock so far.
        }
        return secondSell; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}
