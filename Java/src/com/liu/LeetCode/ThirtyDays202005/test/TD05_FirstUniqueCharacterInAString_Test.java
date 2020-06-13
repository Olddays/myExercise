package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD05_FirstUniqueCharacterInAString.firstUniqChar;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD05_FirstUniqueCharacterInAString_Test {

    public static void main(String[] args) {
        String[] strings = new String[]{
                "aadadaad",
                "leetcode",
                "loveleetcode"
        };
        int result;
        long startTime;
        long endTime;

        for (String s : strings) {
            startTime = System.currentTimeMillis();
            result = testMy1(s);
            endTime = System.currentTimeMillis();
            System.out.println("TD05_FirstUniqueCharacterInAString My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(String s) {
        return firstUniqChar(s);
    }

}
