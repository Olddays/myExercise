package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC717_1_BitAnd2_BitCharacters.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC717_1_BitAnd2_BitCharactersTest {

    public static void main(String[] args) {
        int[] bits = {
                1, 0, 0
        };
        long startTime;
        boolean result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(bits);
        endTime = System.currentTimeMillis();
        System.out.println("1_BitAnd2_BitCharacters Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(bits);
        endTime = System.currentTimeMillis();
        System.out.println("1_BitAnd2_BitCharacters Answer 2 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testAnswer1(int[] bits) {
        return get1_BitAnd2_BitCharactersAnswer1(bits);
    }

    private static boolean testAnswer2(int[] bits) {
        return get1_BitAnd2_BitCharactersAnswer2(bits);
    }
}
