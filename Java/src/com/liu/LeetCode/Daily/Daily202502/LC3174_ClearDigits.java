package com.liu.LeetCode.Daily.Daily202502;

import java.util.Stack;

public class LC3174_ClearDigits {
    // Beats 74.08%
    private static String clearDigitsMy1(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "abc",
                "cb34",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = clearDigitsMy1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("queryResults My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
