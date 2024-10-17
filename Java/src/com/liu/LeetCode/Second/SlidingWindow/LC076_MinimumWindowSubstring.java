package com.liu.LeetCode.Second.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC076_MinimumWindowSubstring {
    /* Given two strings s and t of lengths m and n respectively, return the minimum window substring
    of s such that every character in t (including duplicates) is included in the window.
    If there is no such substring, return the empty string "".
    The testcases will be generated such that the answer is unique.*/

    private static String minWindowMy1(String s, String t) { // 会停留在第一个符合的子字符串不继续往下找更优的解
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < tLength) {
            return "";
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int right;
        for (right = 0; right < sLength; right++) { // 找到右
            char rightChar = s.charAt(right);
            if (!charMap.containsKey(rightChar)) {
                continue;
            }
            if (charMap.get(rightChar) > 1) {
                charMap.put(rightChar, charMap.get(rightChar) - 1);
            } else if (charMap.get(rightChar) == 1) {
                charMap.remove(rightChar);
            }
            if (charMap.isEmpty()) {
                break;
            }
        }

        for (char c : t.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int left;
        for (left = right; left >= 0; left--) { // 找到左
            char leftChar = s.charAt(left);
            if (!charMap.containsKey(leftChar)) {
                continue;
            }
            if (charMap.get(leftChar) > 1) {
                charMap.put(leftChar, charMap.get(leftChar) - 1);
            } else if (charMap.get(leftChar) == 1) {
                charMap.remove(leftChar);
            }
            if (charMap.isEmpty()) {
                break;
            }
        }
        return s.substring(left, right + 1);
    }

    private static String minWindowMy2(String s, String t) { // Time Limit Exceeded 性能太差，写的也太丑了
        String result = "";
        int length = s.length();
        if (length < t.length()) {
            return result;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int left;
        for (left = 0; left < length; left++) { // 排除最前无用的字段，定位到第一个位置
            char leftChar = s.charAt(left);
            if (charMap.containsKey(leftChar)) {
                break;
            }
        }
        int right = left;
        while (right < length) {
            char rightChar = s.charAt(right);
            if (!charMap.containsKey(rightChar)) {
                right++;
                continue;
            }
            if (charMap.get(rightChar) > 1) {
                charMap.put(rightChar, charMap.get(rightChar) - 1);
            } else if (charMap.get(rightChar) == 1) {
                charMap.remove(rightChar);
            }
            if (charMap.isEmpty()) {
                String cache = s.substring(left, right + 1);
                if (result.isEmpty() || cache.length() < result.length()) {
                    result = cache;
                }
                for (char c : t.toCharArray()) {
                    charMap.put(c, charMap.getOrDefault(c, 0) + 1);
                }
                left++;
                for (; left < length; left++) { // 排除最前无用的字段，定位到第一个位置
                    char leftChar = s.charAt(left);
                    if (charMap.containsKey(leftChar)) {
                        break;
                    }
                }
                right = left;
            } else {
                right++;
            }
        }
        return result;
    }

    private static String minWindowMy3(String s, String t) { // accepted
        String result = "";
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < tLength) {
            return result;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        for (int right = 0; right < sLength; right++) {
            char rightChar = s.charAt(right);
            if (!charMap.containsKey(rightChar)) {
                continue;
            }
            if (charMap.get(rightChar) > 0) { // 要注意规避AAAB寻找AB的情况
                tLength--;
            }
            charMap.put(rightChar, charMap.get(rightChar) - 1);
            if (tLength == 0) {
                char leftChar = s.charAt(left);
                while (!charMap.containsKey(leftChar) || charMap.get(leftChar) < 0) {
                    if (charMap.containsKey(leftChar)) {
                        charMap.put(leftChar, charMap.getOrDefault(leftChar, 0) + 1);
                        // 用于规避AAAB寻找AB的情况
                    }
                    left++;
                    leftChar = s.charAt(left);
                }
                String cache = s.substring(left, right + 1);
                if (result.isEmpty() || cache.length() < result.length()) {
                    result = cache;
                }
                charMap.put(leftChar, charMap.getOrDefault(leftChar, 0) + 1);
                left++;
                tLength++;
            }
        }
        return result;
    }

    private static String minWindowAnswer1(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < tLength) {
            return "";
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int[] minWindow = {0, Integer.MAX_VALUE};
        int startIndex = 0;

        for (int endIndex = 0; endIndex < sLength; endIndex++) {
            char ch = s.charAt(endIndex);
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                tLength--;
            }
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

            if (tLength == 0) {
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
                        break;
                    }
                    charCount.put(charAtStart, charCount.getOrDefault(charAtStart, 0) + 1);
                    startIndex++;
                }

                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }

                charCount.put(s.charAt(startIndex), charCount.getOrDefault(s.charAt(startIndex), 0) + 1);
                tLength++;
                startIndex++;
            }
        }

        return minWindow[1] >= sLength ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "AABC",
                "ADOBECODEBANC",
                "a",
                "a",
        };
        String[] tList = new String[]{
                "ABC",
                "ABC",
                "a",
                "aa",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minWindowMy1(sList[i], tList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minWindow My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minWindowMy2(sList[i], tList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minWindow My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minWindowMy3(sList[i], tList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minWindow My3 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minWindowAnswer1(sList[i], tList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minWindow Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}