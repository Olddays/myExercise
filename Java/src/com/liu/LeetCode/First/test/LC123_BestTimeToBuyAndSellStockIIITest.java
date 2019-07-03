package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC123_BestTimeToBuyAndSellStockIII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC123_BestTimeToBuyAndSellStockIIITest {

    public static void main(String[] args) {
        int[] input = new int[]{
//                7, 1, 5, 3, 6, 4
//                7, 6, 4, 3, 1
//                2, 4, 1
//                1, 2
                3, 3, 5, 0, 0, 3, 1, 4
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockIII My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(input);
        endTime = System.currentTimeMillis();
        System.out.println("BestTimeToBuyAndSellStockIII Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] input) {
        return getBestTimeToBuyAndSellStockIIIMy1(input);
    }

    private static int testAnswer1(int[] input) {
        return getBestTimeToBuyAndSellStockIIIAnswer1(input);
    }
}
