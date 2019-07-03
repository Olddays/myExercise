package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC309_BestTimeToBuyAndSellStockWithCooldown {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
     * <p>
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     * <p>
     * Example:
     * <p>
     * prices = [1, 2, 3, 0, 2]
     * maxProfit = 3
     * transactions = [buy, sell, cooldown, buy, sell]
     * <p>
     * Credits:
     * Special thanks to @dietpepsi for adding this problem and creating all test cases.
     */

    // 肯定是个dp问题
    public static int getBestTimeToBuyAndSellStockWithCooldownMy1(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[length / 2][length];
        for (int dealTime = 1; dealTime < length / 2; dealTime++) {
            int cache = prices[0]; // 第一天的价格
            for (int i = 1; i < length; i++) {
                dp[dealTime][i] = Math.max(dp[dealTime][i - 1], prices[i] + cache);
                cache = Math.min(cache, prices[i] - dp[dealTime - 1][i - 1]);
            }
        }
        return dp[length / 2 - 1][length - 1];
    }

    /**
     * The series of problems are typical dp. The key for dp is to find the variables to represent the states and deduce the transition function.
     * <p>
     * Of course one may come up with a O(1) space solution directly, but I think it is better to be generous when you think and be greedy when you implement.
     * <p>
     * The natural states for this problem is the 3 possible transactions : buy, sell, rest. Here rest means no transaction on that day (aka cooldown).
     * <p>
     * Then the transaction sequences can end with any of these three states.
     * <p>
     * For each of them we make an array, buy[n], sell[n] and rest[n].
     * <p>
     * buy[i] means before day i what is the maxProfit for any sequence end with buy.
     * <p>
     * sell[i] means before day i what is the maxProfit for any sequence end with sell.
     * <p>
     * rest[i] means before day i what is the maxProfit for any sequence end with rest.
     * <p>
     * Then we want to deduce the transition functions for buy sell and rest. By definition we have:
     * <p>
     * buy[i]  = max(rest[i-1]-price, buy[i-1])
     * sell[i] = max(buy[i-1]+price, sell[i-1])
     * rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
     * <p>
     * Where price is the price of day i. All of these are very straightforward. They simply represents :
     * <p>
     * (1) We have to `rest` before we `buy` and
     * (2) we have to `buy` before we `sell`
     * <p>
     * One tricky point is how do you make sure you sell before you buy, since from the equations it seems that [buy, rest, buy] is entirely possible.
     * <p>
     * Well, the answer lies within the fact that buy[i] <= rest[i] which means rest[i] = max(sell[i-1], rest[i-1]). That made sure [buy, rest, buy] is never occurred.
     * <p>
     * A further observation is that and rest[i] <= sell[i] is also true therefore
     * <p>
     * rest[i] = sell[i-1]
     * <p>
     * Substitute this in to buy[i] we now have 2 functions instead of 3:
     * <p>
     * buy[i] = max(sell[i-2]-price, buy[i-1])
     * sell[i] = max(buy[i-1]+price, sell[i-1])
     * <p>
     * This is better than 3, but
     * <p>
     * we can do even better
     * <p>
     * Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1). And here we are at our final solution:
     */
    public static int getBestTimeToBuyAndSellStockWithCooldownAnswer1(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int sell = 0;
        int prev_sell = 0;
        int buy = Integer.MIN_VALUE;
        int prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
