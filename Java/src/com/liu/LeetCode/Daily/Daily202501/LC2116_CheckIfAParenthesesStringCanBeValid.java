package com.liu.LeetCode.Daily.Daily202501;

public class LC2116_CheckIfAParenthesesStringCanBeValid {

    // beats 58.92%
    private static boolean canBeValidMy1(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] lockedChars = locked.toCharArray();
        int balanceCount = 0; // 记录固定值的左右括号的配对情况
        int wildCount = 0; // 记录活动值的数量
        for (int i = 0; i < sChars.length && balanceCount + wildCount >= 0; i++) { // 左到右 balanceCount + wildCount >= 0 保证右括号不多于左括号
            if (lockedChars[i] == '1') { // 固定
                if (sChars[i] == '(') {
                    balanceCount++;
                } else if (sChars[i] == ')') {
                    balanceCount--;
                }
            } else if (lockedChars[i] == '0') { // 活动
                wildCount++;
            }
        }
        if (Math.abs(balanceCount) > wildCount) {
            return false;
        }
        balanceCount = 0;
        wildCount = 0;
        for (int i = sChars.length - 1; i >= 0 && balanceCount + wildCount >= 0; i--) { // 右到左 balanceCount + wildCount >= 0 保证左括号不多于右括号
            if (lockedChars[i] == '1') { // 固定
                if (sChars[i] == ')') {
                    balanceCount++;
                } else if (sChars[i] == '(') {
                    balanceCount--;
                }
            } else if (lockedChars[i] == '0') { // 活动
                wildCount++;
            }
        }
        if (Math.abs(balanceCount) > wildCount) {
            return false;
        }
        return true;
    }

    private static boolean validate(String s, String locked, char op) {
        int bal = 0, wild = 0, sz = s.length();
        int start = op == '(' ? 0 : sz - 1, dir = op == '(' ? 1 : -1;
        for (int i = start; i >= 0 && i < sz && wild + bal >= 0; i += dir)
            if (locked.charAt(i) == '1')
                bal += s.charAt(i) == op ? 1 : -1;
            else
                ++wild;
        return Math.abs(bal) <= wild;
    }

    private static boolean canBeValidAnswer1(String s, String locked) {
        return s.length() % 2 == 0 && validate(s, locked, '(') && validate(s, locked, ')');
    }

    // beats 83.40%
    private static boolean canBeValidAnswer2(String s, String locked) {
        if (s.length() % 2 != 0)
            return false;

        int balanceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(')
                balanceCount++;
            else
                balanceCount--;
            if (balanceCount < 0)
                return false;
        }

        balanceCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')')
                balanceCount++;
            else
                balanceCount--;
            if (balanceCount < 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(",
                "))((",
                "))()))",
                "()()",
                ")",
        };
        String[] lockedList = new String[]{
                "100011110110011011010111100111011101111110000101001101001111",
                "0011",
                "010100",
                "0000",
                "0",
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = canBeValidMy1(sList[i], lockedList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canBeValid My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = canBeValidAnswer1(sList[i], lockedList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canBeValid Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = canBeValidAnswer2(sList[i], lockedList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canBeValid Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
