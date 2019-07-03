package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by liu on 2017/9/30.
 */
public class LC049_GroupAnagrams {
    /**
     * Given an array of strings, group anagrams together.
     * <p>
     * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Return:
     * <p>
     * [
     * ["ate", "eat", "tea"],
     * ["nat", "tan"],
     * ["bat"]
     * ]
     * <p>
     * Note: All inputs will be in lower-case.
     */

    // 无法处理部分情况
    public static List<List<String>> getGroupAnagramsMy1(String[] strs) {
        int length = strs.length;
        List<List<String>> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        Map<Integer, List<String>> cache = new HashMap<>();
        for (String str : strs) {
            int multi = 1;
            for (char c : str.toCharArray()) {
                multi *= c;
            }
            List<String> list;
            if (cache.containsKey(multi)) {
                list = cache.get(multi);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            cache.put(multi, list);
        }
        for (Map.Entry<Integer, List<String>> entry : cache.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static List<List<String>> getGroupAnagramsMy2(String[] strs) {
        int length = strs.length;
        List<List<String>> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        Map<String, List<String>> cache = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = "";
            for (char c : chars) {
                key += c;
            }
            List<String> list;
            if (cache.containsKey(key)) {
                list = cache.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            cache.put(key, list);
        }
        for (Map.Entry<String, List<String>> entry : cache.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
