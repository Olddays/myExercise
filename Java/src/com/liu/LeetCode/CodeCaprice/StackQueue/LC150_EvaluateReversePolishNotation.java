package com.liu.LeetCode.CodeCaprice.StackQueue;

import java.util.Stack;

public class LC150_EvaluateReversePolishNotation {
    private static int evalRPNMy1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);
            } else if (token.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            } else if (token.equals("*")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 * num2);
            } else if (token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[][] tokensSet = new String[][]{
                {"18"},
                {"4", "13", "5", "/", "+"},
                {"2", "1", "+", "3", "*"},
                {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < tokensSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = evalRPNMy1(tokensSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("evalRPN My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
