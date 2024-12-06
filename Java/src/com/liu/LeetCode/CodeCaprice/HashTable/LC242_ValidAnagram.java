package com.liu.LeetCode.CodeCaprice.HashTable;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC242_ValidAnagram {

    // 哈希题目，首先可以考虑一下数组，数组比较快
    private static boolean isAnagramMy1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cache = new int[26];
        for (char c : s.toCharArray()) {
            cache[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cache[c - 'a']--;
        }
        for (int i : cache) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str1List = new String[]{
                "anagram",
                "rat",
        };
        String[] str2List = new String[]{
                "nagaram",
                "car",
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < str1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = isAnagramMy1(str1List[i], str2List[i]);
            endTime = System.currentTimeMillis();
            System.out.println("isAnagram My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
