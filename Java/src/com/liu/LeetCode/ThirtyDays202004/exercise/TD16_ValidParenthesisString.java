package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD16_ValidParenthesisString {
    public static boolean checkValidStringMy1(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        int leftCount = 0;
        int starCount = 0;
        for (char c : chars) {
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                if (leftCount > 0) {
                    leftCount--;
                } else if (starCount > 0) {
                    starCount--;
                } else {
                    return false;
                }
            } else if (c == '*') {
                starCount++;
            }
        }
        return leftCount == 0;
    }

    public static boolean checkValidStringMy2(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        s = s.replaceAll("\\(\\)", "");
        while (s.length() != length) {
            length = s.length();
            s = s.replaceAll("\\(\\)", "");
        }
        int leftLeft = 0;
        int leftRight = 0;
        int rightRight = 0;
        int rightLeft = 0;
        for (int i = 0; i < length; i++) {
            char lc = s.charAt(i);
            if (lc == '(' || lc == '*') {
                leftLeft++;
            } else if (lc == ')') {
                leftRight++;
            }
            if (leftLeft < leftRight) {
                return false;
            }
            char rc = s.charAt(length - i - 1);
            if (rc == '(') {
                rightLeft++;
            } else if (rc == ')' || rc == '*') {
                rightRight++;
            }
            if (rightRight < rightLeft) {
                return false;
            }
        }
        return true;
    }
}
