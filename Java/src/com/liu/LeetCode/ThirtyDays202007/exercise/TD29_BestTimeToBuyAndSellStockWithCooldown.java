package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/29.
 */
public class TD29_BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int[] s0 = new int[length];
        int[] s1 = new int[length];
        int[] s2 = new int[length];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[length - 1], s2[length - 1]);
    }

    public static int maxProfitOptimize(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int sold = 0;
        int hold = Integer.MIN_VALUE;
        int rest = 0;
        for (int price : prices) {
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, sold);
            sold = hold + price;
        }
        return Math.max(sold, rest);
    }
}
