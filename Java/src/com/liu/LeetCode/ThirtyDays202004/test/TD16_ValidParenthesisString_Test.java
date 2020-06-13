package com.liu.LeetCode.ThirtyDays202004.test;


import static com.liu.LeetCode.ThirtyDays202004.exercise.TD16_ValidParenthesisString.checkValidStringMy1;
import static com.liu.LeetCode.ThirtyDays202004.exercise.TD16_ValidParenthesisString.checkValidStringMy2;

public class TD16_ValidParenthesisString_Test {

    public static void main(String[] args) {
        String[] stringList = new String[]{
                "(())((())()()(*)(*()(())())())()()((()())((()))(*",
                "(*)",
                "(*()",
                "()",
                "(*))"
        };
        boolean result;
        long startTime;
        long endTime;

        for (String s : stringList) {
            startTime = System.currentTimeMillis();
            result = testMy1(s);
            endTime = System.currentTimeMillis();
            System.out.println("TD16_ValidParenthesisString My 1 result: " + result + ", during time " + (endTime - startTime));
        }

        for (String s : stringList) {
            startTime = System.currentTimeMillis();
            result = testMy2(s);
            endTime = System.currentTimeMillis();
            System.out.println("TD16_ValidParenthesisString My 2 result: " + result + ", during time " + (endTime - startTime));
        }
    }

    private static boolean testMy1(String s) {
        return checkValidStringMy1(s);
    }

    private static boolean testMy2(String s) {
        return checkValidStringMy2(s);
    }
}
