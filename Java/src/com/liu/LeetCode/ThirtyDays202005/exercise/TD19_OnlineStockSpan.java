package com.liu.LeetCode.ThirtyDays202005.exercise;

import java.util.Stack;

/**
 * Created by Liu on 2020/5/26.
 */
public class TD19_OnlineStockSpan {

    public static class StockSpanner {
        private Stack<Integer> prices;
        private Stack<Integer> weights;

        public StockSpanner() {
            prices = new Stack<>();
            weights = new Stack<>();
        }

        public int next(int price) {
            int w = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                w += weights.pop();
            }

            prices.push(price);
            weights.push(w);
            return w;
        }
    }
}
