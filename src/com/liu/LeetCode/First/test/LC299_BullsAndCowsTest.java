package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC299_BullsAndCows.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC299_BullsAndCowsTest {

    public static void main(String[] args) {
        String[] pattenrs = new String[]{
                "1807",
                "1123",
                "1122"
        };
        String[] guesss = new String[]{
                "7810",
                "0111",
                "3456"
        };
        long startTime;
        String result;
        long endTime;

        for (int i = 0; i < pattenrs.length; i++) {
            String secret = pattenrs[i];
            String guess = guesss[i];

            startTime = System.currentTimeMillis();
            result = testMy1(secret, guess);
            endTime = System.currentTimeMillis();
            System.out.println("BullsAndCows My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(secret, guess);
            endTime = System.currentTimeMillis();
            System.out.println("BullsAndCows My 2 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(secret, guess);
            endTime = System.currentTimeMillis();
            System.out.println("BullsAndCows Answer 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer2(secret, guess);
            endTime = System.currentTimeMillis();
            System.out.println("BullsAndCows Answer 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static String testMy1(String secret, String guess) {
        return getBullsAndCowsMy1(secret, guess);
    }

    private static String testMy2(String secret, String guess) {
        return getBullsAndCowsMy2(secret, guess);
    }

    private static String testAnswer1(String secret, String guess) {
        return getBullsAndCowsAnswer1(secret, guess);
    }

    private static String testAnswer2(String secret, String guess) {
        return getBullsAndCowsAnswer2(secret, guess);
    }
}
