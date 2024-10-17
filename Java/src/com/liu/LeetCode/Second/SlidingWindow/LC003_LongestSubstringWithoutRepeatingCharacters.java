package com.liu.LeetCode.Second.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LC003_LongestSubstringWithoutRepeatingCharacters {
    private static int lengthOfLongestSubstringMy1(String s) { // 过了但用时太久
        int result = 0;
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int left = 0;
        int right = 1;
        while (left < right && right < length) { // 这个重复循环是可以优化的
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            String cache = "";
            cache += leftChar;
            while (cache.indexOf(rightChar) == -1) { // 这个重复循环是可以优化的
                cache += rightChar;
                right++;
                if (right == length) {
                    break;
                }
                rightChar = s.charAt(right);
            }
            result = Math.max(result, cache.length());
            left += cache.indexOf(rightChar) + 1;
            right = left + 1;
        }
        return result;
    }

    private static int lengthOfLongestSubstringAnswer1(String s) {
        int length = s.length();
        int result = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < length; right++) {
            char rightChar = s.charAt(right);
            if (!charSet.contains(rightChar)) {
                charSet.add(rightChar);
                result = Math.max(result, right - left + 1);
            } else {
                while (charSet.contains(rightChar)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(rightChar);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{
                "pwwkew",
                "abcabcbb",
                "bbbbb",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < strings.length; i++) {
            startTime = System.currentTimeMillis();
            result = lengthOfLongestSubstringMy1(strings[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lengthOfLongestSubstring My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < strings.length; i++) {
            startTime = System.currentTimeMillis();
            result = lengthOfLongestSubstringAnswer1(strings[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lengthOfLongestSubstring Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
