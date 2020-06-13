package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD13_RemoveKDigits.removeKdigitsAnswer1;
import static com.liu.LeetCode.ThirtyDays202005.exercise.TD13_RemoveKDigits.removeKdigitsMy1;
import static com.liu.LeetCode.ThirtyDays202005.exercise.TD13_RemoveKDigits.removeKdigitsMy2;

/**
 * Created by Liu on 2020/5/13.
 */
public class TD13_RemoveKDigits_Test {
    public static void main(String[] args) {
        String num;
        int k;
        String result;
        long startTime;
        long endTime;

        num = "11111111";
        k = 4;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));



        num = "43214321";
        k = 4;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));


        num = "1173";
        k = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));


        num = "1274";
        k = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));


        num = "112";
        k = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));


        num = "122";
        k = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));


        num = "10200";
        k = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));


        num = "1432219";
        k = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));


        num = "10";
        k = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));


        num = "10";
        k = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(num, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_RemoveKDigits Answer 1 result " + result + " during time " + (endTime - startTime));

    }

    private static String testMy1(String num, int k) {
        return removeKdigitsMy1(num, k);
    }

    private static String testMy2(String num, int k) {
        return removeKdigitsMy2(num, k);
    }

    private static String testAnswer1(String num, int k) {
        return removeKdigitsAnswer1(num, k);
    }

}
