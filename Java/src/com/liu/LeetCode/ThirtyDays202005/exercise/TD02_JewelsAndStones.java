package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD02_JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        int length = S.length();
        if (length == 0) {
            return 0;
        }
        int result = 0;
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (J.indexOf(c) != -1) {
                result++;
            }
        }
        return result;
    }
}
