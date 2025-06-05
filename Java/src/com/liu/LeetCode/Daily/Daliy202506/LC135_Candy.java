package com.liu.LeetCode.Daily.Daliy202506;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC135_Candy {

    // 从左往右一次，找到右边比左边大的，那么右边的糖果就等于左边的糖果+1
    // 再从右往左一次，找到左边比右边大的，那么左边的糖果就等于右边的糖果+1和原本这个位置上值更大的那个
    private static int candyMy1(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Left to Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Right to Left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        // Total
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] ratingsList = new int[][]{
                {1, 0, 2},
                {1, 1, 4},
        };
        int[] resultList = new int[]{
                5,
                4,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < ratingsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = candyMy1(ratingsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("candy My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
