package com.liu.LeetCode.ThirtyDays202005.test;

import java.util.*;

/**
 * Created by Liu on 2020/5/24.
 */
public class TD22_SortCharactersByFrequency_Test {
    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        HashMap<Character, Integer> cache = new HashMap<>();
        for (char c : s.toCharArray()) {
            cache.put(c, cache.getOrDefault(c, 0) + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(cache.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        String result = "";
        for (Map.Entry<Character, Integer> entry : list) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result += c;
            }
        }
        return result;
    }
}
