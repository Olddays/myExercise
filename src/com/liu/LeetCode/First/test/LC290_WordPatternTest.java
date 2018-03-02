package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC290_WordPattern.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC290_WordPatternTest {

    public static void main(String[] args) {
        String[] pattenrs = new String[]{
                "abba",
                "abba",
                "aaaa",
                "abba"
        };
        String[] strs = new String[]{
                "dog cat cat dog",
                "dog cat cat fish",
                "dog cat cat dog",
                "dog dog dog dog"
        };
        long startTime;
        boolean result;
        long endTime;

        for (int i = 0; i < pattenrs.length; i++) {
            String pattern = pattenrs[i];
            String str = strs[i];

            startTime = System.currentTimeMillis();
            result = testMy1(pattern, str);
            endTime = System.currentTimeMillis();
            System.out.println("WordPattern My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(pattern, str);
            endTime = System.currentTimeMillis();
            System.out.println("WordPattern My 2 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(pattern, str);
            endTime = System.currentTimeMillis();
            System.out.println("WordPattern Answer 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static boolean testMy1(String pattern, String str) {
        return getWordPatternMy1(pattern, str);
    }

    private static boolean testMy2(String pattern, String str) {
        return getWordPatternMy2(pattern, str);
    }

    private static boolean testAnswer1(String pattern, String str) {
        return getWordPatternAnswer1(pattern, str);
    }
}
