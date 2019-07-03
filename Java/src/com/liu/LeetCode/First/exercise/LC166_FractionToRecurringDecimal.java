package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liu on 2017/9/30.
 */
public class LC166_FractionToRecurringDecimal {
    /**
     * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
     * <p>
     * If the fractional part is repeating, enclose the repeating part in parentheses.
     * <p>
     * For example,
     * <p>
     * Given numerator = 1, denominator = 2, return "0.5".
     * Given numerator = 2, denominator = 1, return "2".
     * Given numerator = 2, denominator = 3, return "0.(6)".
     * <p>
     * Credits:
     * Special thanks to @Shangrila for adding this problem and creating all test cases.
     */

    // 无法处理1,333的输入
    public static String getFractionToRecurringDecimalMy1(int numerator, int denominator) {
        int integerPart = numerator / denominator;
        int doublePartNumber = numerator % denominator;
        String part = String.valueOf(integerPart);
        if (doublePartNumber > 0) {
            boolean isEndless = checkEndless(denominator);
            if (isEndless) {
                part += ".";
                int start;
                List<Integer> partList = new ArrayList<>();
                while (true) {
                    int result = doublePartNumber * 10 / denominator;
                    doublePartNumber = doublePartNumber * 10 % denominator;
                    if (partList.contains(result)) {
                        start = partList.indexOf(result);
                        break;
                    }
                    partList.add(result);
                }
                for (int i = 0; i < partList.size(); i++) {
                    if (i == start) {
                        part += "(";
                    }
                    part += partList.get(i);
                }
                part += ")";
            } else {
                part = String.valueOf((double) numerator / (double) denominator);
            }
        } else {
            part = String.valueOf(numerator / denominator);
        }
        return part;
    }

    private static boolean checkEndless(int denominator) {
        int cache = denominator;
        while (cache % 2 == 0) {
            cache /= 2;
        }
        if (cache != 1) {
            while (cache % 5 == 0) {
                cache /= 5;
            }
            return cache != 1;
        }
        return false;
    }

    /**
     * The important thing is to consider all edge cases while thinking this problem through, including: negative integer, possible overflow, etc.
     * <p>
     * Use HashMap to store a remainder and its associated index while doing the division so that whenever a same remainder comes up, we know there is a repeating fractional part.
     * <p>
     * Please comment if you see something wrong or can be improved. Cheers!
     */
    public static String getFractionToRecurringDecimalAnswer1(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : ""); // 先判断一下正负
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        // 重点在于这个HashMap的key,这个key是用于表示上次除法的余数
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
