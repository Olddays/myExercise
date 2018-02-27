package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC290_WordPattern {
    /**
     * Given a pattern and a string str, find if str follows the same pattern.
     * <p>
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
     * <p>
     * Examples:
     * pattern = "abba", str = "dog cat cat dog" should return true.
     * pattern = "abba", str = "dog cat cat fish" should return false.
     * pattern = "aaaa", str = "dog cat cat dog" should return false.
     * pattern = "abba", str = "dog dog dog dog" should return false.
     * Notes:
     * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
     * <p>
     * Credits:
     * Special thanks to @minglotus6 for adding this problem and creating all test cases.
     */

    // 无法处理"abba", "dog dog dog dog"的输入,只判断了一样没有判断不一样
    public static boolean getWordPatternMy1(String pattern, String str) {
        int patternLength = pattern.length();
        String[] strs = str.split(" ");
        if (patternLength == 0 || strs.length != patternLength) {
            return false;
        }
        Map<Character, List<Integer>> patternMap = new HashMap<>();
        char[] patternChars = pattern.toCharArray();
        for (int i = 0; i < patternLength; i++) {
            char c = patternChars[i];
            List<Integer> list;
            if (patternMap.containsKey(c)) {
                list = patternMap.get(c);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            patternMap.put(c, list);
        }
        for (Map.Entry<Character, List<Integer>> entry : patternMap.entrySet()) {
            List<Integer> list = entry.getValue();
            String cache = strs[list.get(0)];
            for (int i : list) {
                if (!strs[i].equals(cache)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean getWordPatternMy2(String pattern, String str) {
        int patternLength = pattern.length();
        String[] strs = str.split(" ");
        if (patternLength == 0 || strs.length != patternLength) {
            return false;
        }
        Map<Character, List<Integer>> patternMap = new HashMap<>();
        char[] patternChars = pattern.toCharArray();
        for (int i = 0; i < patternLength; i++) {
            char c = patternChars[i];
            List<Integer> list;
            if (patternMap.containsKey(c)) {
                list = patternMap.get(c);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            patternMap.put(c, list);
        }
        Set<String> stringSet = new HashSet<>();
        for (Map.Entry<Character, List<Integer>> entry : patternMap.entrySet()) {
            List<Integer> list = entry.getValue();
            String cache = strs[list.get(0)];
            for (int i : list) {
                if (!strs[i].equals(cache)) {
                    return false;
                }
            }
            if (stringSet.contains(cache)) {
                return false;
            }
            stringSet.add(cache);
        }
        return true;
    }

    /**
     * I go through the pattern letters and words in parallel and compare the indexes where they last appeared.
     * <p>
     * Edit 1: Originally I compared the first indexes where they appeared, using putIfAbsent instead of put. That was based on mathsam's solution for the old Isomorphic Strings problem. But then czonzhu's answer below made me realize that put works as well and why.
     * <p>
     * Edit 2: Switched from
     * for (int i=0; i<words.length; ++i)
     * if (!Objects.equals(index.put(pattern.charAt(i), i),
     * index.put(words[i], i)))
     * return false;
     * to the current version with i being an Integer object, which allows to compare with just != because there's no autoboxing-same-value-to-different-objects-problem anymore. Thanks to lap_218 for somewhat pointing that out in the comments.
     */
    public static boolean getWordPatternAnswer1(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
