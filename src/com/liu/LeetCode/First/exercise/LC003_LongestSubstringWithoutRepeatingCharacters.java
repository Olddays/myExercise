package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/6.
 */
public class LC003_LongestSubstringWithoutRepeatingCharacters {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * Examples:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    // 没有考虑记录数字的第一个值
    public static int getLongestSubstringWithoutRepeatingCharactersMy1(String s) {
        char[] charsCache = s.toCharArray();
        char cache;
        LinkedList<Character> characterList = new LinkedList<>();
        List<Integer> locationList = new ArrayList<>();
        for (int i = 0; i < charsCache.length; i++) {
            char c = charsCache[i];
            cache = c;
            if (characterList.contains(cache)) {
                locationList.add(i);
            } else {
                characterList.add(c);
            }
        }
        int length = 0;
        for (int i = 1; i < locationList.size(); i++) {
            int nowLength = locationList.get(i) - locationList.get(i - 1);
            length = nowLength > length ? nowLength : length;
        }

        return length;
    }

    // 没有考虑输入为空String的时候的边界情况
    public static int getLongestSubstringWithoutRepeatingCharactersMy2(String s) {
        char[] charsCache = s.toCharArray();
        char cache;
        LinkedList<Character> characterList = new LinkedList<>();
        List<Integer> locationList = new ArrayList<>();
        for (int i = 0; i < charsCache.length; i++) {
            char c = charsCache[i];
            cache = c;
            if (characterList.contains(cache)) {
                locationList.add(i);
            } else {
                characterList.add(c);
            }
        }
        int length = locationList.get(0);
        for (int i = 1; i < locationList.size(); i++) {
            int nowLength = locationList.get(i) - locationList.get(i - 1);
            length = nowLength > length ? nowLength : length;
        }

        return length;
    }

    // 没有考虑输入字符串没有重复的内容的时候的判断
    public static int getLongestSubstringWithoutRepeatingCharactersMy3(String s) {
        if (null == s || s.equals("")) {
            return 0;
        }
        char[] charsCache = s.toCharArray();
        char cache;
        LinkedList<Character> characterList = new LinkedList<>();
        List<Integer> locationList = new ArrayList<>();
        for (int i = 0; i < charsCache.length; i++) {
            char c = charsCache[i];
            cache = c;
            if (characterList.contains(cache)) {
                locationList.add(i);
            } else {
                characterList.add(c);
            }
        }
        int length = locationList.get(0);
        for (int i = 1; i < locationList.size(); i++) {
            int nowLength = locationList.get(i) - locationList.get(i - 1);
            length = nowLength > length ? nowLength : length;
        }

        return length;
    }

    // 当输入"aab"的时候返回为1而不是期待结果2,未考虑当最后出现最长字符串的情况
    public static int getLongestSubstringWithoutRepeatingCharactersMy4(String s) {
        if (null == s || s.equals("")) {
            return 0;
        }
        char[] charsCache = s.toCharArray();
        char cache;
        LinkedList<Character> characterList = new LinkedList<>();
        List<Integer> locationList = new ArrayList<>();
        for (int i = 0; i < charsCache.length; i++) {
            char c = charsCache[i];
            cache = c;
            if (characterList.contains(cache)) {
                locationList.add(i);
            } else {
                characterList.add(c);
            }
        }
        if (locationList.size() == 0) {
            return charsCache.length;
        }
        int length = locationList.get(0);
        for (int i = 1; i < locationList.size(); i++) {
            int nowLength = locationList.get(i) - locationList.get(i - 1);
            length = nowLength > length ? nowLength : length;
        }

        return length;
    }

    // 当输入dvdf的时候错误,即当重复出现在子串内部的时候错误
    // 整体思路错误
    public static int getLongestSubstringWithoutRepeatingCharactersMy5(String s) {
        if (null == s || s.equals("")) {
            return 0;
        }
        char[] charsCache = s.toCharArray();
        char cache;
        LinkedList<Character> characterList = new LinkedList<>();
        List<Integer> locationList = new ArrayList<>();
        for (int i = 0; i < charsCache.length; i++) {
            char c = charsCache[i];
            cache = c;
            if (characterList.contains(cache)) {
                locationList.add(i);
            }
            characterList.add(c);
        }
        locationList.add(charsCache.length);
        int length = locationList.get(0);
        for (int i = 1; i < locationList.size(); i++) {
            int nowLength = locationList.get(i) - locationList.get(i - 1);
            length = nowLength > length ? nowLength : length;
        }

        return length;
    }

    // 在一些情况下,需要多循环那么几次的时候,使用while来代替for
    public static int getLongestSubstringWithoutRepeatingCharactersAnswer1(String s) {
        if (null == s || s.equals("")) {
            return 0;
        }
        char[] charsCache = s.toCharArray();
        Map<Character, Integer> cacheMap = new HashMap<>();

        int fast = 0;
        int slow = 0;
        int length = charsCache.length;
        int maxLength = 0;
        while (fast < length) {
            char f = charsCache[fast];
            if (!cacheMap.containsKey(f)) {
                cacheMap.put(f, 1);
                maxLength = maxLength > cacheMap.size() ? maxLength : cacheMap.size();
                fast++;
            } else {
                // 此处将会从0开始将已经存放在map中的char全部删除
                char sl = charsCache[slow];
                cacheMap.remove(sl);
                slow++;
            }
        }

        return maxLength;
    }

    // 在一些情况下,需要多循环那么几次的时候,使用while来代替for
    // 改善空间占用,使用List代替Map
    /** Warning: 当使用List代替Map的时候,List的contains操作很费时,可能会导致时间长度超出预期 */
    public static int getLongestSubstringWithoutRepeatingCharactersAnswer1Update(String s) {
        if (null == s || s.equals("")) {
            return 0;
        }
        char[] charsCache = s.toCharArray();
        List<Character> cacheList = new ArrayList<>();

        int fast = 0;
        int slow = 0;
        int length = charsCache.length;
        int maxLength = 0;
        while (fast < length) {
            char f = charsCache[fast];
            if (!cacheList.contains(f)) {
                cacheList.add(f);
                maxLength = maxLength > cacheList.size() ? maxLength : cacheList.size();
                fast++;
            } else {
                // 此处将会从0开始将已经存放在map中的char全部删除
                char sl = charsCache[slow];
                cacheList.remove(Character.valueOf(sl));
                slow++;
            }
        }

        return maxLength;
    }
}
