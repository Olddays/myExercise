package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC066_PlusOne {
    /**
     * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
     * <p>
     * You may assume the integer do not contain any leading zero, except the number 0 itself.
     * <p>
     * The digits are stored such that the most significant digit is at the head of the list.
     */

    // 输入[9],输出[1,0];输入[1,0],输出[1,1]
    public static int[] getPlusOneMy1(int[] digits) {
        int length = digits.length;
        if (length == 0) {
            return new int[]{1};
        }
        boolean upload = true;
        String part = "";
        for (int i = length - 1; i >= 0; i--) {
            int cache = digits[i];
            if (upload) {
                upload = false;
                cache++;
            }
            if (cache >= 10) {
                upload = true;
                part = (cache % 10) + part;
            } else {
                part = cache + part;
            }
        }
        if (upload) {
            part = "1" + part;
        }
        int[] result = new int[part.length()];
        char[] chars = part.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 48是'0'的编码值
            result[i] = chars[i] - 48;
        }
        return result;
    }

    // 比较取巧的方式,输入的最后一位如果等于9才需要进位,否则直接加1再return就好
    public static int[] getPlusOneAnswer1(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
