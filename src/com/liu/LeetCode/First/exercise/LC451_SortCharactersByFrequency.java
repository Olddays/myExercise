package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC451_SortCharactersByFrequency {
    /**
     * Given a string, sort it in decreasing order based on the frequency of characters.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * "tree"
     * <p>
     * Output:
     * "eert"
     * <p>
     * Explanation:
     * 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     * <p>
     * Input:
     * "cccaaa"
     * <p>
     * Output:
     * "cccaaa"
     * <p>
     * Explanation:
     * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     * Example 3:
     * <p>
     * Input:
     * "Aabb"
     * <p>
     * Output:
     * "bbAa"
     * <p>
     * Explanation:
     * "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     */

    // HashMap并不会自动排序,所以会出现错误
    public static String getSortCharactersByFrequencyMy1(String s) {
        int length = s.length();
        String result = "";
        if (length == 0) {
            return result;
        }
        int[] cache = new int[256];
        for (int i = 0; i < length; i++) {
            cache[s.charAt(i)]++;
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < cache.length; i++) {
            int size = cache[i];
            if (size > 0) {
                char c = (char) i;
                List<Character> list;
                if (map.containsKey(size)) {
                    list = map.get(size);
                } else {
                    list = new ArrayList<>();
                }
                list.add(c);
                map.put(size, list);
            }
        }
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            List<Character> list = entry.getValue();
            for (char c : list) {
                for (int i = 0; i < entry.getKey(); i++) {
                    result = c + result;
                }
            }
        }
        return result;
    }

    // TreeMap的时间复杂度过高,会出现 Time Limit Exceeded
    public static String getSortCharactersByFrequencyMy2(String s) {
        int length = s.length();
        String result = "";
        if (length == 0) {
            return result;
        }
        int[] cache = new int[256];
        for (int i = 0; i < length; i++) {
            cache[s.charAt(i)]++;
        }
        Map<Integer, List<Character>> map = new TreeMap<>();
        for (int i = 0; i < cache.length; i++) {
            int size = cache[i];
            if (size > 0) {
                char c = (char) i;
                List<Character> list;
                if (map.containsKey(size)) {
                    list = map.get(size);
                } else {
                    list = new ArrayList<>();
                }
                list.add(c);
                map.put(size, list);
            }
        }
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            List<Character> list = entry.getValue();
            for (char c : list) {
                for (int i = 0; i < entry.getKey(); i++) {
                    result = c + result;
                }
            }
        }
        return result;
    }

    /**
     * The logic is very similar to NO.347 and here we just use a map a count and according to the frequency to put it into the right bucket.
     * Then we go through the bucket to get the most frequently character and append that to the final stringbuilder.
     */
    public static String getSortCharactersByFrequencyAnswer1(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] != null) {
                for (char num : bucket[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * And we have normal way using PriorityQueue as follows:
     */
    public static String getSortCharactersByFrequencyAnswer2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                        return b.getValue() - a.getValue();
                    }
                }
        );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

    /**
     * Build a map of characters to the number of times it occurs in the string
     * Create an array where the index of the array represents how many times that character occurred in the String
     * Iterate from the end of the array to the beginning, and at each index, append each character to the return string that number of times.
     */
    public static String getSortCharactersByFrequencyAnswer3(String s) {
        if (s == null) {
            return null;
        }
        Map<Character, Integer> map = new HashMap();
        char[] charArray = s.toCharArray();
        int max = 0;
        for (Character c : charArray) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
            max = Math.max(max, map.get(c));
        }

        List<Character>[] array = buildArray(map, max);

        return buildString(array);
    }

    private static List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
        List<Character>[] array = new List[maxCount + 1];
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (array[count] == null) {
                array[count] = new ArrayList();
            }
            array[count].add(c);
        }
        return array;
    }

    private static String buildString(List<Character>[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i > 0; i--) {
            List<Character> list = array[i];
            if (list != null) {
                for (Character c : list) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
