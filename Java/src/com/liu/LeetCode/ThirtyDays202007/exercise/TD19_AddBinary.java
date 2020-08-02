package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/20.
 */
public class TD19_AddBinary {

    public static String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        if (m == 0) {
            return b;
        } else if (n == 0) {
            return a;
        }
        int cache = 0;
        String result = "";
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        while (m > 0 && n > 0) {
            int count = aChars[--m] - '0' + bChars[--n] - '0' + cache;
            cache = count / 2;
            result = count % 2 + result;
        }
        while (m > 0) {
            int count = aChars[--m] - '0' + cache;
            cache = count / 2;
            result = count % 2 + result;
        }
        while (n > 0) {
            int count = bChars[--n] - '0' + cache;
            cache = count / 2;
            result = count % 2 + result;
        }
        if (cache > 0) {
            result = cache + result;
        }
        return result;
    }

}
