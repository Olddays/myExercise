package com.liu.LeetCode.ThirtyDays202005.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/5/19.
 */
public class TD17_FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }
        int[] pmap = new int[26];
        int[] smap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pmap[p.charAt(i) - 'a']++;
            smap[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (matches(pmap, smap)) {
                result.add(i);
            }
            smap[s.charAt(i + p.length()) - 'a']++;
            smap[s.charAt(i) - 'a']--;
        }
        if (matches(pmap, smap)) {
            result.add(s.length() - p.length());
        }
        return result;
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
