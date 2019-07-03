package com.liu.LeetApp.exercise;

/**
 * Created by liu on 2016/12/6.
 */
public class LA008_BestTimeToBuyAndSellStock {

    // Say you have an array for which the ith element is price of a given stock on day i.

    // If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
    // design an algorithm to find the maximum profit.

    // Difficulty: Medium

    // Not Perfect 时间复杂度O(n2) 未做初始判空
    public static int bestTimeToBuyAndSellStockMy1(int[] input) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                result = input[i] - input[j] > result ? input[i] - input[j] : result;
            }
        }
        return result;
    }

    public static int bestTimeToBuyAndSellStockAnswer(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE; // just remember the smallest price. 时间换空间 真棒
        int result = 0;
        for (int i : input) {
            min = i < min ? i : min;
            result = (i - min) > result ? i - min : result;
        }
        return result;
    }
}
