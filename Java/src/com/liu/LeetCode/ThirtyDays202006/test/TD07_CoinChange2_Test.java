package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD07_CoinChange2.changeMy1;
import static com.liu.LeetCode.ThirtyDays202006.exercise.TD07_CoinChange2.changeMy2;
import static com.liu.LeetCode.ThirtyDays202006.exercise.TD07_CoinChange2.changeAnswer1;

/**
 * Created by Liu on 2020/6/7.
 */
public class TD07_CoinChange2_Test {
    public static void main(String[] args) {
        int amount;
        int[] coins;
        int result;
        long startTime;
        long endTime;

        amount = 500;
        coins = new int[]{
                3, 5, 7, 8, 9, 10, 11
        };
        startTime = System.currentTimeMillis();
        result = testMy1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 1 result " + result + " during time " + (endTime - startTime));

        amount = 0;
        coins = new int[]{
        };
        startTime = System.currentTimeMillis();
        result = testMy1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 1 result " + result + " during time " + (endTime - startTime));

        amount = 5;
        coins = new int[]{
                1, 2, 5
        };
        startTime = System.currentTimeMillis();
        result = testMy1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 1 result " + result + " during time " + (endTime - startTime));

        amount = 3;
        coins = new int[]{
                2
        };
        startTime = System.currentTimeMillis();
        result = testMy1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 1 result " + result + " during time " + (endTime - startTime));

        amount = 10;
        coins = new int[]{
                10
        };
        startTime = System.currentTimeMillis();
        result = testMy1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 1 result " + result + " during time " + (endTime - startTime));


        amount = 500;
        coins = new int[]{
                3, 5, 7, 8, 9, 10, 11
        };
        startTime = System.currentTimeMillis();
        result = testMy2(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 2 result " + result + " during time " + (endTime - startTime));

        amount = 0;
        coins = new int[]{
        };
        startTime = System.currentTimeMillis();
        result = testMy2(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 2 result " + result + " during time " + (endTime - startTime));

        amount = 5;
        coins = new int[]{
                1, 2, 5
        };
        startTime = System.currentTimeMillis();
        result = testMy2(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 2 result " + result + " during time " + (endTime - startTime));

        amount = 3;
        coins = new int[]{
                2
        };
        startTime = System.currentTimeMillis();
        result = testMy1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 2 result " + result + " during time " + (endTime - startTime));

        amount = 10;
        coins = new int[]{
                10
        };
        startTime = System.currentTimeMillis();
        result = testMy2(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 My 2 result " + result + " during time " + (endTime - startTime));


        amount = 500;
        coins = new int[]{
                3, 5, 7, 8, 9, 10, 11
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 Answer 1 result " + result + " during time " + (endTime - startTime));

        amount = 0;
        coins = new int[]{
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 Answer 1 result " + result + " during time " + (endTime - startTime));

        amount = 5;
        coins = new int[]{
                1, 2, 5
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 Answer 1 result " + result + " during time " + (endTime - startTime));

        amount = 3;
        coins = new int[]{
                2
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 Answer 1 result " + result + " during time " + (endTime - startTime));

        amount = 10;
        coins = new int[]{
                10
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(amount, coins);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CoinChange2 Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int amount, int[] coins) {
        return changeMy1(amount, coins);
    }

    private static int testMy2(int amount, int[] coins) {
        return changeMy2(amount, coins);
    }

    private static int testAnswer1(int amount, int[] coins) {
        return changeAnswer1(amount, coins);
    }

}
