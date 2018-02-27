package com.liu.LeetApp.exercise;

/**
 * Created by baidu on 2016/12/6.
 */
public class LA010_BestTimeToBuyAndSellStockIII {

    // Say you have an array for which the ith element is the price of a given stock on day i.

    // Design an algorithm to find the maximum profit. You may complete at most two transactions.

    // Note:
    // You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

    // Difficulty: Hard

    // Not Perfect 毕竟用了O(n4) 时间复杂度太高了
    public static int bestTimeToBuyAndSellStockIIIMy1(int[] input) {
        if (null == input || input.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = input.length - 1; j > i; j--) {
                for (int left = i + 1; left < j; left++) {
                    for (int right = j - 1; right > left; right--) {
                        int cache = input[left] - input[i] + input[j] - input[right];
                        result = result > cache ? result : cache;
                    }
                }

            }
        }
        return result;
    }

    // 又是经典的空间换时间,非常好的思路,由于买入和卖出必须分开,所以从左从右各进行一次遍历后取最大值来保证结果,时间复杂度O(3n)
    public static int bestTimeToBuyAndSellStockIIIAnswer(int[] input) {
        if (null == input || input.length <= 1) {
            return 0;
        }
        int[] left = new int[input.length];
        int[] right = new int[input.length];

        // DP from left to right
        left[0] = 0;
        int min = input[0];
        for (int i = 1; i < input.length; i++) {
            min = Math.min(input[i], min);
            left[i] = Math.max(left[i - 1], input[i] - min);
        }
        // DP from right to left
        right[input.length - 1] = 0;
        int max = input[input.length - 1];
        for (int i = input.length - 2; i >= 0; i--) {
            max = Math.max(input[i], max);
            right[i] = Math.max(right[i + 1], max - input[i]);
        }
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            result = Math.max(left[i] + right[i], result);
        }
        return result;
    }
}
