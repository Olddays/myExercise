package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC017_LetterCombinationsOfAPhoneNumber {

    private static final Map<Character, List<Character>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    // 做的时候有一些混乱，还是应该按部就班的先画一个树状图来确保自己的思路正确
    // Beats 58.47%
    private static List<String> letterCombinationsMy1(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        char[] digitsArray = digits.toCharArray();
        backtrackMy1(result, new StringBuilder(), digitsArray, 0);
        return result;
    }

    private static void backtrackMy1(List<String> result, StringBuilder stringBuilder, char[] digitsArray, int digitsIndex) {
        if (stringBuilder.length() == digitsArray.length) {
            result.add(stringBuilder.toString());
            return;
        }
        char digit = digitsArray[digitsIndex];
        List<Character> letters = map.get(digit);
        for (int i = 0; i < letters.size(); i++) {
            stringBuilder.append(letters.get(i));
            backtrackMy1(result, stringBuilder, digitsArray, digitsIndex + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        String[] digitsList = new String[]{
                "23",
                "",
                "2",
        };
        List<String> result;
        long startTime;
        long endTime;

        for (int i = 0; i < digitsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = letterCombinationsMy1(digitsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("letterCombinations My1 result" + i + " ");
            for (String val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
