package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC274_H_Index.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC274_H_IndexTest {

    public static void main(String[] args) {
        int[] citations = {
//                3, 0, 6, 1, 5
                100
        };
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(citations);
        endTime = System.currentTimeMillis();
        System.out.println("H_Index My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(citations);
        endTime = System.currentTimeMillis();
        System.out.println("H_Index Answer 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer2(citations);
        endTime = System.currentTimeMillis();
        System.out.println("H_Index Answer 2 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] citations) {
        return getH_IndexMy1(citations);
    }

    private static int testAnswer1(int[] citations) {
        return getH_IndexAnswer1(citations);
    }

    private static int testAnswer2(int[] citations) {
        return getH_IndexAnswer2(citations);
    }
}
