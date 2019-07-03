package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC387_FirstUniqueCharacterInAString.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC387_FirstUniqueCharacterInAStringTest {

    public static void main(String[] args) {
        String[] strings = {
                "leetcode",
                "loveleetcode"
        };
        long startTime;
        int result;
        long endTime;

        for (String s : strings) {
            startTime = System.currentTimeMillis();
            result = testAnswer1(s);
            endTime = System.currentTimeMillis();
            System.out.println("FirstUniqueCharacterInAString My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testAnswer1(String s) {
        return getFirstUniqueCharacterInAStringMy1(s);
    }
}
