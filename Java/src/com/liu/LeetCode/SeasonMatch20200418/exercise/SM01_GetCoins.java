package com.liu.LeetCode.SeasonMatch20200418.exercise;

public class SM01_GetCoins {
    public static int minCount(int[] coins) {
        int length = coins.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        for (int coin : coins) {
            result += coin / 2 + coin % 2;
        }
        return result;
    }
}
