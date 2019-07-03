package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC409_LongestPalindrome {
    /**
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
     * <p>
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     * <p>
     * Note:
     * Assume the length of given string will not exceed 1,010.
     * <p>
     * Example:
     * <p>
     * Input:
     * "abccccdd"
     * <p>
     * Output:
     * 7
     * <p>
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     */

    public static int getLongestPalindromeMy1(String s) {
        int length = s.length();
        int result = 0;
        if (length == 0) {
            return result;
        }
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c > 'Z') {
                lower[c - 'a']++;
            } else {
                upper[c - 'A']++;
            }
        }
        boolean hasSingle = false;
        for (int i : lower) {
            if (i >= 2) {
                result += i / 2 * 2;
            }
            if (i % 2 == 1) {
                hasSingle = true;
            }
        }
        for (int i : upper) {
            if (i >= 2) {
                result += i / 2 * 2;
            }
            if (i % 2 == 1) {
                hasSingle = true;
            }
        }
        if (hasSingle) {
            result++;
        }
        return result;
    }
}
