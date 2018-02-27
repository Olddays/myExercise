package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC205_IsomorphicStrings.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC205_IsomorphicStringsTest {

    public static void main(String[] args) {
        String[] strings = new String[]{
                "ab", "egg", "foo", "paper", ""
        };
        String[] targets = new String[]{
                "aa", "add", "bar", "title", ""
        };
        long startTime;
        boolean result;
        long endTime;

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            String t = targets[i];

            startTime = System.currentTimeMillis();
            result = testMy1(s, t);
            endTime = System.currentTimeMillis();
            System.out.println("IsomorphicStrings My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(s, t);
            endTime = System.currentTimeMillis();
            System.out.println("IsomorphicStrings My 2 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(s, t);
            endTime = System.currentTimeMillis();
            System.out.println("IsomorphicStrings Answer 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer2(s, t);
            endTime = System.currentTimeMillis();
            System.out.println("IsomorphicStrings Answer 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static boolean testMy1(String s, String t) {
        return getIsomorphicStringsMy1(s, t);
    }

    private static boolean testMy2(String s, String t) {
        return getIsomorphicStringsMy2(s, t);
    }

    private static boolean testAnswer1(String s, String t) {
        return getIsomorphicStringsAnswer1(s, t);
    }

    private static boolean testAnswer2(String s, String t) {
        return getIsomorphicStringsAnswer2(s, t);
    }
}
