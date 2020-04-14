package com.liu.LeetCode.ThirtyDays202004.exercise;

import java.util.ArrayList;

public class TD05_BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        ArrayList<Integer> cache = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            int next = prices[i];
            if (next <= max) {
                cache.add(max - min);
                min = next;
                max = next;
            } else {
                min = Math.min(min, next);
                max = Math.max(max, next);
            }
        }
        if (min < max) {
            cache.add(max - min);
        }
        int result = 0;
        for (int i : cache) {
            result += i;
        }
        return result;
    }
}
