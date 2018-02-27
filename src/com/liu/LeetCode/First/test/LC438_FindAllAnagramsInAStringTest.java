package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC438_FindAllAnagramsInAString.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC438_FindAllAnagramsInAStringTest {

    public static void main(String[] args) {
        String[] strings = {
                "cbaebabacd",
                "abab",
                "ba"
        };
        String[] targets = {
                "abc",
                "ab",
                "a"
        };
        long startTime;
        List<Integer> result;
        long endTime;

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            String t = targets[i];

            startTime = System.currentTimeMillis();
            result = testMy1(s, t);
            endTime = System.currentTimeMillis();
            System.out.println("FindAllAnagramsInAString My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();

            startTime = System.currentTimeMillis();
            result = testAnswer1(s, t);
            endTime = System.currentTimeMillis();
            System.out.println("FindAllAnagramsInAString Answer 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();

            startTime = System.currentTimeMillis();
            result = testAnswer2(s, t);
            endTime = System.currentTimeMillis();
            System.out.println("FindAllAnagramsInAString Answer 2 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> testMy1(String s, String t) {
        return getFindAllAnagramsInAStringMy1(s, t);
    }

    private static List<Integer> testAnswer1(String s, String t) {
        return getFindAllAnagramsInAStringAnswer1(s, t);
    }

    private static List<Integer> testAnswer2(String s, String t) {
        return getFindAllAnagramsInAStringAnswer2(s, t);
    }
}
