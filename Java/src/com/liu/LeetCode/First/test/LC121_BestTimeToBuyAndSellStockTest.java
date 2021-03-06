package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC121_BestTimeToBuyAndSellStock.getBestTimeToBuyAndSellStockMy1;

/**
 * Created by liu on 2017/9/14.
 */
public class LC121_BestTimeToBuyAndSellStockTest {

    public static void main(String[] args) {
        int[] input = new int[]{
//                7, 1, 5, 3, 6, 4
//                7, 6, 4, 3, 1
                2, 4, 1
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStock My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return getBestTimeToBuyAndSellStockMy1(input);
    }
}
