package com.liu.LeetCode.ThirtyDays202005.exercise;

import java.util.Stack;

/**
 * Created by Liu on 2020/5/13.
 */
public class TD13_RemoveKDigits {
    public static String removeKdigitsMy1(String num, int k) {
        int length = num.length();
        if (length <= k) {
            return "0";
        }
        int min = '9';
        for (int i = 0; i < k; i++) {
            int n = num.charAt(i);
            min = Math.min(min, n);
        }
        num = num.substring(k);
        int cache = 0;
        if (num.charAt(cache) >= min) {
            while (cache < length - k && num.charAt(cache) == min) {
                cache++;
            }
            num = num.replaceFirst(String.valueOf(num.charAt(cache)), String.valueOf((char) min));
        }
        cache = 0;
        while (cache < length - k && num.charAt(cache) == '0') {
            cache++;
        }
        if (cache == length - k) {
            return "0";
        }
        return num.substring(cache);
    }

    public static String removeKdigitsMy2(String num, int k) {
        int length = num.length();
        if (length <= k) {
            return "0";
        }
        String part1 = num.substring(0, k);
        int length1 = part1.length();
        String part2 = num.substring(k);
        int length2 = part2.length();

        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            char c1 = part1.charAt(i);
            char c2 = part2.charAt(j);
            if (c2 > c1) {
                part2 = part2.replaceFirst(String.valueOf(c2), String.valueOf(c1));
            }
            if (c1 == c2) {
                j++;
            } else {
                i++;
                j++;
            }
        }

        int cache = 0;
        while (cache < length2 && part2.charAt(cache) == '0') {
            cache++;
        }
        if (cache == length2) {
            return "0";
        }
        return part2.substring(cache);
    }

    public static String removeKdigitsAnswer1(String num, int k) {
        int length = num.length();
        //corner case
        if (k == length) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        // corner case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        //remove all the 0 at the head
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
