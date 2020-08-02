package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD12_ReverseBits.reverseBits;

/**
 * Created by Liu on 2020/7/13.
 */
public class TD12_ReverseBits_Test {

    public static void main(String[] args) {
        int n;
        int result;
        long startTime;
        long endTime;


        n = Integer.valueOf("00000010100101000001111010011100", 2);
        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD12_ReverseBits My 1 result: " + result + ", during time " + (endTime - startTime));

        n = Integer.valueOf("11111111111111111111111111111101", 2);
        startTime = System.currentTimeMillis();
        result = testMy1(n);
        endTime = System.currentTimeMillis();
        System.out.println("TD12_ReverseBits My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int n) {
        return reverseBits(n);
    }
}
