package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC242_ValidAnagram.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC242_ValidAnagramTest {

    public static void main(String[] args) {
        String[] strings = new String[]{
                "aacc", "anagram", "rat"
        };
        String[] targets = new String[]{
                "ccac", "nagaram", "car"
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
            System.out.println("ValidAnagram My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(s, t);
            endTime = System.currentTimeMillis();
            System.out.println("ValidAnagram Answer 1 result " + result + " during time " + (endTime - startTime));

            System.out.println();
        }
    }

    private static boolean testMy1(String s, String t) {
        return getValidAnagramMy1(s, t);
    }

    private static boolean testAnswer1(String s, String t) {
        return getValidAnagramAnswer1(s, t);
    }
}
