package com.liu.SelfTest.test;

import static com.liu.SelfTest.exercise.MT001_DynamicProgrammingCoinNumber.getDynamicProgrammingCoinNumberMy1;

/**
 * Created by baidu on 2016/11/27.
 */
public class MT001_DynamicProgrammingCoinNumberTest {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 3, 5};
        int target = 11;
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(coins, target);
        endTime = System.currentTimeMillis();
        System.out.println("getDynamicProgrammingCoinNumber My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] coins, int target) {
        return getDynamicProgrammingCoinNumberMy1(coins, target);
    }

}
