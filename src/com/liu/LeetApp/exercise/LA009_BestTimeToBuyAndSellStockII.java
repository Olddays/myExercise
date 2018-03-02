package com.liu.LeetApp.exercise;

/**
 * Created by liu on 2016/12/6.
 */
public class LA009_BestTimeToBuyAndSellStockII {

    // Say you have an array for which the ith element is the price of a given stock on day i.

    // Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie,
    // buy one and sell one share of the stock multiple time).
    // However, you may not engage in multiple transactions at the same time (ie,
    // you must sell the stock before you buy again).

    // Difficulty: Medium

    // Error right应该递减
    public static int bestTimeToBuyAndSellStockIIMy1(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int left = i - 1;
                int right = input.length - 1;
                while (left < right && i > left && i < right && j > left && j < right) {
                    min = min < input[left] ? min : input[left];
                    max = max > input[right] ? max : input[right];
                    int cache = input[i] - input[left] + input[right] - input[j];
                    result = result < cache ? cache : result;
                    left++;
                    right++;
                }
            }
        }
        return result;
    }

    // Error max选择错误,max和min没有使用
    public static int bestTimeToBuyAndSellStockIIMy2(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < input.length; i++) {
            int left = i - 1;
            for (int j = input.length - 1; j > i; j--) {
                int right = j - 1;
                while (left < right && i > left && i < right && j > left && right < j) {
                    min = min < input[left] ? min : input[left];
                    max = max > input[right] ? max : input[right];
                    int cache = input[i] - input[left] + input[right] - input[j];
                    result = result < cache ? cache : result;
                    right--;
                }
            }
            left++;
        }
        return result;
    }

    // Error 处理方案并不合理,max和min会变成全局的而非局部的,也就会导致max和min无意义
    public static int bestTimeToBuyAndSellStockIIMy3(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < input.length; i++) {
            for (int j = input.length - 1; j > i; j--) {
                int left = i - 1;
                int right = j - 1;
                while (left < right && i > left && i < right && j > left && right < j) {
                    min = min < input[left] ? min : input[left];
                    max = max > input[j] ? max : input[j];
                    int cache = input[i] - min + input[right] - max;
                    result = result < cache ? cache : result;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    // 理解错了题意.要认真读题
    public static int bestTimeToBuyAndSellStockIIAnswer(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < input.length - 1; i++) {
            int diff = input[i + 1] - input[i];
            if (diff > 0) {
                result += diff;
            }
        }
        return result;
    }
}
