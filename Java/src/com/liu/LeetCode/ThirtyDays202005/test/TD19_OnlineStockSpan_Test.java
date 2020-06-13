package com.liu.LeetCode.ThirtyDays202005.test;

import com.liu.LeetCode.ThirtyDays202005.exercise.TD19_OnlineStockSpan.StockSpanner;

/**
 * Created by Liu on 2020/5/26.
 */
public class TD19_OnlineStockSpan_Test {
    public static void main(String[] args) {
        int[] dailyStockList = {100, 80, 60, 70, 65, 75, 85};
        int result;
        long startTime;
        long endTime;
        StockSpanner stockSpanner = new StockSpanner();

        int[] answerList = {1, 1, 1, 2, 1, 4, 6};

        for (int dailyStock : dailyStockList) {
            startTime = System.currentTimeMillis();
            result = stockSpanner.next(dailyStock);
            endTime = System.currentTimeMillis();
            System.out.println("TD19_OnlineStockSpan My 1 result " + result + " during time " + (endTime - startTime));
        }
    }
}
