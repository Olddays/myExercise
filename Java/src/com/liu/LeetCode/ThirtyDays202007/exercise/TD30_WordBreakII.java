package com.liu.LeetCode.ThirtyDays202007.exercise;

import java.util.*;

/**
 * Created by Liu on 2020/7/30.
 */
public class TD30_WordBreakII {
    static int a = 0;
    static int b = 0;

    // Time Limited
    public static List<String> wordBreakMy1(String s, List<String> wordDict) {
        Map<Character, List<String>> wordMap = new HashMap<>();
        for (String word : wordDict) {
            char key = word.charAt(0);
            List<String> value = wordMap.getOrDefault(key, new ArrayList<>());
            value.add(word);
            wordMap.put(key, value);
        }
        List<String> result = new ArrayList<>();
        checkPossibility(s, wordMap, result, "", 0);
        System.out.println("a "+a);
        return result;
    }

    private static void checkPossibility(String s, Map<Character, List<String>> wordMap, List<String> dataSet,
                                         String cache, int index) {
        a++;
        if (index == s.length()) {
            if (!dataSet.contains(cache)) {
                dataSet.add(cache.substring(1));
            }
        } else if (index < s.length()) {
            char target = s.charAt(index);
            List<String> wordList = wordMap.get(target);
            if (wordList != null) {
                for (String word : wordList) {
                    int nextIndex = index + word.length();
                    if (nextIndex <= s.length() && s.substring(index, nextIndex).equals(word)) {
                        checkPossibility(s, wordMap, dataSet, cache + " " + word, nextIndex);
                    }
                }
            }
        }
    }

    public static List<String> wordBreakAnswer1(String s, List<String> wordDict) {
        return DepthFirstSearch(s, wordDict, new HashMap<>());
    }

    // DepthFirstSearch function returns an array including all substrings derived from s.
    private static List<String> DepthFirstSearch(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        b++;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DepthFirstSearch(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
