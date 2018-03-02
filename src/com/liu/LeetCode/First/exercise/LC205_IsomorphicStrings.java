package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liu on 2017/9/30.
 */
public class LC205_IsomorphicStrings {
    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character but a character may map to itself.
     * <p>
     * For example,
     * Given "egg", "add", return true.
     * <p>
     * Given "foo", "bar", return false.
     * <p>
     * Given "paper", "title", return true.
     * <p>
     * Note:
     * You may assume both s and t have the same length.
     */

    // 可以处理"aa","ab"的输入,但是不能处理"ab","aa",因为我们只判断了前半部分
    public static boolean getIsomorphicStringsMy1(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) {
            return false;
        }
        char[] stringChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        Map<Character, List<Integer>> stringMap = new HashMap<>();
        for (int i = 0; i < sLength; i++) {
            List<Integer> list;
            if (stringMap.containsKey(stringChars[i])) {
                list = stringMap.get(stringChars[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            stringMap.put(stringChars[i], list);
        }
        for (Map.Entry<Character, List<Integer>> entry : stringMap.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > 1) {
                char cache = targetChars[list.get(0)];
                for (int i : list) {
                    if (cache != targetChars[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean getIsomorphicStringsMy2(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) {
            return false;
        }
        char[] stringChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        Map<Character, List<Integer>> stringMap = new HashMap<>();
        Map<Character, List<Integer>> targetMap = new HashMap<>();
        for (int i = 0; i < sLength; i++) {
            List<Integer> list;
            if (stringMap.containsKey(stringChars[i])) {
                list = stringMap.get(stringChars[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            stringMap.put(stringChars[i], list);

            if (targetMap.containsKey(targetChars[i])) {
                list = targetMap.get(targetChars[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            targetMap.put(targetChars[i], list);
        }
        for (Map.Entry<Character, List<Integer>> entry : stringMap.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > 1) {
                char cache = targetChars[list.get(0)];
                for (int i : list) {
                    if (cache != targetChars[i]) {
                        return false;
                    }
                }
            }
        }
        for (Map.Entry<Character, List<Integer>> entry : targetMap.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > 1) {
                char cache = stringChars[list.get(0)];
                for (int i : list) {
                    if (cache != stringChars[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean getIsomorphicStringsAnswer1(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) {
            return false;
        }
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        char[] stringChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        for (int i = 0; i < sLength; ++i) {
            if (m1[stringChars[i]] != m2[targetChars[i]]) {
                return false;
            }
            m1[stringChars[i]] = i + 1;
            m2[targetChars[i]] = i + 1;
        }
        return true;
    }

    /**
     * Hi guys!
     * <p>
     * The main idea is to store the last seen positions of current (i-th) characters in both strings. If previously stored positions are different then we know that the fact they're occuring in the current i-th position simultaneously is a mistake. We could use a map for storing but as we deal with chars which are basically ints and can be used as indices we can do the whole thing with an array.
     * <p>
     * Check the code below. Happy coding!
     */
    public static boolean getIsomorphicStringsAnswer2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] m = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 256]) {
                return false;
            }
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
