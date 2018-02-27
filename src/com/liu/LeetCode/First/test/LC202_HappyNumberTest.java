package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC202_HappyNumber.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC202_HappyNumberTest {

    public static void main(String[] args) {
        int[] input = new int[]{
                19, 7
        };
        long startTime;
        boolean result;
        long endTime;

        for (int n : input) {
            startTime = System.currentTimeMillis();
            result = testMy1(n);
            endTime = System.currentTimeMillis();
            System.out.println("HappyNumber My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static boolean testMy1(int n) {
        return getHappyNumberMy1(n);
    }
}
