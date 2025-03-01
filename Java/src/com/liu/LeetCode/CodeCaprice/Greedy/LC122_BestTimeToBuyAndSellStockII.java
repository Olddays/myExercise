package com.liu.LeetCode.CodeCaprice.Greedy;

public class LC122_BestTimeToBuyAndSellStockII {

    // Beats 78.84%
    private static int maxProfitMy1(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[][] pricesList = new int[][]{
                {7, 1, 5, 3, 6, 4},
                {1, 2, 3, 4, 5},
                {7, 6, 4, 3, 1},
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < pricesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxProfitMy1(pricesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxProfit My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
