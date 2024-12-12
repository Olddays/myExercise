package com.liu.LeetCode.CodeCaprice.StackQueue;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.Stack;

public class LC020_ValidParentheses {
    private static boolean isValidMy1(String s) {
        int length = s.length();
        if (length % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char cache : chars) {
            if (cache == '(' || cache == '[' || cache == '{') {
                stack.push(cache);
            } else if (cache == ')' || cache == ']' || cache == '}') {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (cache == ')' && pop != '(') return false;
                if (cache == ']' && pop != '[') return false;
                if (cache == '}' && pop != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "()",
                "()[]{}",
                "(]",
                "([])",
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = isValidMy1(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("isValid My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
