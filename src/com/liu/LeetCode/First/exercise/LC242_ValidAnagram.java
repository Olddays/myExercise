package com.liu.LeetCode.First.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC242_ValidAnagram {
    /**
     * Given two strings s and t, write a function to determine if t is an anagram of s.
     * <p>
     * For example,
     * s = "anagram", t = "nagaram", return true.
     * s = "rat", t = "car", return false.
     * <p>
     * Note:
     * You may assume the string contains only lowercase alphabets.
     * <p>
     * Follow up:
     * What if the inputs contain unicode characters? How would you adapt your solution to such case?
     */

    public static boolean getValidAnagramMy1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] stringChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : stringChars) {
            int size = 1;
            if (map.containsKey(c)) {
                size += map.get(c);
            }
            map.put(c, size);
        }
        for (char c : targetChars) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                int size = map.get(c);
                if (size == 1) {
                    map.remove(c);
                } else {
                    map.put(c, size - 1);
                }
            }
        }
        return true;
    }

    /**
     * The idea is simple. It creates a size 26 int arrays as buckets for each letter in alphabet.
     * It increments the bucket value with String s and decrement with string t.
     * So if they are anagrams, all buckets should remain with initial value which is zero. So just checking that and return
     */
    public static boolean getValidAnagramAnswer1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
