package com.liu.LeetCode.Daily.Daily202502;

import java.util.Stack;

public class LC1910_RemoveAllOccurrencesOfASubstring {
    // Beats 30.12%
    private static String removeOccurrencesMy1(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }

    // Beats 30.12%
    private static String removeOccurrencesMy2(String s, String part) {
        Stack<Character> stack = new Stack<>();
        int partLength = part.length();
        char[] sChars = s.toCharArray();
        char[] partChars = part.toCharArray();
        char targetChar = partChars[partLength - 1];
        char[] tmpChar = new char[partLength];
        for (char c : sChars) {
            stack.push(c);
            if (stack.size() >= partLength && c == targetChar) {
                boolean hasMatch = true;
                for (int i = partLength - 1; i >= 0; i--) {
                    tmpChar[i] = stack.pop();
                    if (tmpChar[i] != partChars[i]) {
                        hasMatch = false;
                    }
                }
                if (!hasMatch) {
                    for (char t : tmpChar) {
                        stack.push(t);
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    // Beats 60.40%
    private static String removeOccurrencesAnswer1(String s, String part) {
        int index = s.indexOf(part);
        while (index != -1) {
            s = s.substring(0, index) + s.substring(index + part.length());
            index = s.indexOf(part);
        }
        return s;
    }

    // Beats 99.46%
    private static String removeOccurrencesAnswer2(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf(part) != -1) {
            int idx = sb.indexOf(part);
            sb.delete(idx, idx + part.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "daabcbaabcbc",
                "axxxxyyyyb",
        };
        String[] partList = new String[]{
                "abc",
                "xy",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = removeOccurrencesMy1(sList[i], partList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeOccurrences My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = removeOccurrencesMy2(sList[i], partList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeOccurrences My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = removeOccurrencesAnswer1(sList[i], partList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeOccurrences Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = removeOccurrencesAnswer2(sList[i], partList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeOccurrences Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
