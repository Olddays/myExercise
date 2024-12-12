package com.liu.LeetCode.CodeCaprice.StackQueue;

import java.util.Stack;

public class LC1047_RemoveAllAdjacentDuplicatesInString {
    // 性能很差 Beats10.21%
    private static String removeDuplicatesMy1(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        String result = "";
        for (char c : stack) {
            result += c;
        }
        return result;
    }

    private static String removeDuplicatesAnswer1(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // if the current character is same as the last one in `sb`
            // then we cannot push it to `sb`
            // we remove the one in `sb`
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // otherwise, add the current character to `sb`
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "abbaca",
                "azxxzy",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = removeDuplicatesMy1(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeDuplicates My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = removeDuplicatesAnswer1(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeDuplicates Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
