package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC387_FirstUniqueCharacterInAString {
    /**
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     * <p>
     * Examples:
     * <p>
     * s = "leetcode"
     * return 0.
     * <p>
     * s = "loveleetcode",
     * return 2.
     * Note: You may assume the string contain only lowercase letters.
     */

    public static int getFirstUniqueCharacterInAStringMy1(String s) {
        int length = s.length();
        if (length == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int[] cache = new int[26];
        for (char c : chars) {
            cache[c - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            if (cache[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
