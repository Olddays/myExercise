package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD03_RansomNote.canConstruct;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD03_RansomNote_Test {

    public static void main(String[] args) {
        String ransomNote;
        String magazine;
        boolean result;
        long startTime;
        long endTime;

        ransomNote = "fffbfg";
        magazine = "effjfggbffjdgbjjhhdegh";
        startTime = System.currentTimeMillis();
        result = testMy1(ransomNote, magazine);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_RansomNote My 1 result " + result + " during time " + (endTime - startTime));

        ransomNote = "a";
        magazine = "b";
        startTime = System.currentTimeMillis();
        result = testMy1(ransomNote, magazine);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_RansomNote My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(String ransomNote, String magazine) {
        return canConstruct(ransomNote, magazine);
    }

}
