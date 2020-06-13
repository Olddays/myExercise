package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD03_RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int length = ransomNote.length();
        if (length == 0) {
            return true;
        }
        char[] chars = ransomNote.toCharArray();
        for (char c : chars) {
            if (magazine.indexOf(c) == -1) {
                return false;
            }
            magazine = magazine.replaceFirst(String.valueOf(c), "");
        }
        return true;
    }
}
