package com.liu.LeetCode.ThirtyDays202005.exercise;

import static com.liu.LeetCode.ThirtyDays202005.test.TD22_SortCharactersByFrequency_Test.frequencySort;

/**
 * Created by Liu on 2020/5/24.
 */
public class TD22_SortCharactersByFrequency {
    public static void main(String[] args) {
        String s;
        String result;
        long startTime;
        long endTime;

        s = "tree";
        startTime = System.currentTimeMillis();
        result = testMy1(s);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_PermutationInString My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static String testMy1(String s) {
        return frequencySort(s);
    }

}
