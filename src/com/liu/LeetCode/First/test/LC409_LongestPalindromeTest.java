package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC409_LongestPalindrome.getLongestPalindromeMy1;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC409_LongestPalindromeTest {

    public static void main(String[] args) {
        String[] strings = {
                "abccccdd"
        };
        long startTime;
        int result;
        long endTime;

        for (String s : strings) {
            startTime = System.currentTimeMillis();
            result = testAnswer1(s);
            endTime = System.currentTimeMillis();
            System.out.println("LongestPalindrome My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testAnswer1(String s) {
        return getLongestPalindromeMy1(s);
    }
}
