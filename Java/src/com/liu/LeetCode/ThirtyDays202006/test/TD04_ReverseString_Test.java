package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD04_ReverseString.reverseString;

/**
 * Created by Liu on 2020/6/4.
 */
public class TD04_ReverseString_Test {
    public static void main(String[] args) {
        char[] s;
        long startTime;
        long endTime;

        s = new char[]{
                'h', 'e', 'l', 'l', 'o'
        };
        startTime = System.currentTimeMillis();
        testMy1(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD04_ReverseString My 1 result " + s + " during time " + (endTime - startTime));
        for (char c : s) {
            System.out.print(c + " ");
        }
        System.out.println();


        s = new char[]{
                'H', 'a', 'n', 'n', 'a', 'h'
        };
        startTime = System.currentTimeMillis();
        testMy1(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD04_ReverseString My 1 result " + s + " during time " + (endTime - startTime));
        for (char c : s) {
            System.out.print(c + " ");
        }
        System.out.println();

    }

    private static void testMy1(char[] s) {
        reverseString(s);
    }
}
