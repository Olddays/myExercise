package com.liu.LeetCode.ThirtyDays202004.exercise;

import java.util.*;

public class TD06_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> cache = new HashMap<>();
        for (String str : strs) {
            String stringKey = getStringKeyType2(str);
            if (cache.containsKey(stringKey)) {
                cache.get(stringKey).add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                cache.put(stringKey, stringList);
            }
        }
        for (Map.Entry<String, List<String>> entry : cache.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private static String getStringKeyType1(String str) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        String result = "";
        for (char c : cs) {
            result += c;
        }
        return result;
    }

    private static String getStringKeyType2(String str) {
        char[] cs = str.toCharArray();
        int[] cache = new int[26];
        for (char c : cs) {
            cache[c - 'a']++;
        }
        String result = "";
        for (int i : cache) {
            if (i == 0) {
                result += "-";
            } else {
                result += i;
            }
        }
        return result;
    }

}
