package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD09_BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        while (left < S.length() || right < T.length()) {
            if (left < S.length()) {
                if (S.charAt(left) == '#') {
                    if (left > 0) {
                        S = S.substring(0, left - 1) + S.substring(left + 1);
                        left -= 2;
                    } else {
                        S = S.substring(1);
                        left -= 1;
                    }
                }
                left++;
            }
            if (right < T.length()) {
                if (T.charAt(right) == '#') {
                    if (right > 0) {
                        T = T.substring(0, right - 1) + T.substring(right + 1);
                        right -= 2;
                    } else {
                        T = T.substring(1);
                        right -= 1;
                    }
                }
                right++;
            }
        }
        return S.equals(T);
    }
}
