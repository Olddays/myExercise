package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

import static sun.text.normalizer.UTF16.charAt;

public class LC3306_CountOfSubstringsContainingEveryVowelAndKConsonantsII {

    // 移动框体
    // Error，题目理解错误并不是说必须得5+k个字母，而是包含关系，所以也许应该用dp
    private static long countOfSubstringsMyError1(String word, int k) {
        int length = word.length();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        Map<Character, Integer> vowelMap = new HashMap<>();
        for (char vowel : vowels) {
            vowelMap.put(vowel, 0);
        }
        int consonantCount = 0;
        long count = 0;
        for (int i = 0; i < 5 + k; i++) {
            char letter = word.charAt(i);
            if (vowelMap.containsKey(letter)) {
                vowelMap.put(letter, vowelMap.get(letter) + 1);
            } else {
                consonantCount++;
            }
        }
        if (checkSubstring(vowelMap, consonantCount, k)) {
            count++;
        }
        for (int i = 5 + k; i < length; i++) {
            char preLetter = word.charAt(i - 5 - k);
            char letter = word.charAt(i);
            if (vowelMap.containsKey(preLetter)) {
                vowelMap.put(preLetter, vowelMap.get(preLetter) - 1);
            } else {
                consonantCount--;
            } // 去掉后一个
            if (vowelMap.containsKey(letter)) {
                vowelMap.put(letter, vowelMap.get(letter) + 1);
            } else {
                consonantCount++;
            }
            if (checkSubstring(vowelMap, consonantCount, k)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkSubstring(Map<Character, Integer> vowelMap, int consonantCount, int k) {
        if (consonantCount != k) {
            return false;
        }
        for (char vowel : vowelMap.keySet()) {
            if (vowelMap.get(vowel) < 1) {
                return false;
            }
        }
        return true;
    }

    private static long countOfSubstringsMy1(String word, int k) {
        int length = word.length();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int count = 0;
        return count;
    }

    public static void main(String[] args) {
        String[] wordList = new String[]{
                "iqeaouqi",
                "ieaouqqieaouqq",
                "aeioqq",
                "aeiou",
        };
        int[] kList = new int[]{
                2,
                1,
                1,
                0,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < wordList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countOfSubstringsMy1(wordList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countOfSubstrings My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
