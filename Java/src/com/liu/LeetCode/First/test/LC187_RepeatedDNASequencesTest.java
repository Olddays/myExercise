package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC187_RepeatedDNASequences.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC187_RepeatedDNASequencesTest {

    public static void main(String[] args) {
//        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s = "AAAAAAAAAAA";
        long startTime;
        List<String> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(s);
        endTime = System.currentTimeMillis();
        System.out.println("RepeatedDNASequences My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (String string : result) {
            System.out.print(string + " ");
        }
        System.out.println();
    }

    private static List<String> testMy1(String s) {
        return getRepeatedDNASequencesMy1(s);
    }
}
