package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liu on 2017/9/30.
 */
public class LC500_KeyboardRow {
    /**
     * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
     * <p>
     * <p>
     * American keyboard
     * <p>
     * <p>
     * Example 1:
     * Input: ["Hello", "Alaska", "Dad", "Peace"]
     * Output: ["Alaska", "Dad"]
     * Note:
     * You may use one character in the keyboard more than once.
     * You may assume the input string will only contain letters of alphabet.
     */

    public static String[] getKeyboardRowMy1(String[] words) {
        int length = words.length;
        if (length == 0) {
            return new String[0];
        }
        String[] keyboardLines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboardLines.length; i++) {
            char[] chars = keyboardLines[i].toCharArray();
            for (char c : chars) {
                map.put(c, i);
            }
        }

        List<String> list = new ArrayList<>();
        for (String word : words) {
            String newWord = word.toLowerCase();
            boolean isSameLine = true;
            char[] chars = newWord.toCharArray();
            int line = map.get(chars[0]);
            for (char c : chars) {
                if (line != map.get(c)) {
                    isSameLine = false;
                    break;
                }
            }
            if (isSameLine) {
                list.add(word);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
