package com.liu.LeetCode.ThirtyDays202005.exercise;

import java.util.HashMap;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD05_FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> cache = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cache.put(c, cache.getOrDefault(c, 0) + 1);
        }
        for (char c : chars) {
            if (cache.get(c) == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }
}
