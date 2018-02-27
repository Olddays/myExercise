package com.liu.LeetCode.First.test;


import java.util.List;

import static com.liu.LeetCode.First.exercise.LC030_SubstringWithConcatenationOfAllWords.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC030_SubstringWithConcatenationOfAllWordsTest {

    // https://yq.aliyun.com/articles/863

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{
                "foo",
                "bar"
        };
        long startTime;
        List<Integer> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(s, words);
        endTime = System.currentTimeMillis();
        System.out.println("SubstringWithConcatenationOfAllWords My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(" " + i);
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(s, words);
        endTime = System.currentTimeMillis();
        System.out.println("SubstringWithConcatenationOfAllWords Answer 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(" " + i);
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer2(s, words);
        endTime = System.currentTimeMillis();
        System.out.println("SubstringWithConcatenationOfAllWords Answer 2 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    private static List<Integer> testMy1(String s, String[] words) {
        return getSubstringWithConcatenationOfAllWordsMy1(s, words);
    }

    private static List<Integer> testAnswer1(String s, String[] words) {
        return getSubstringWithConcatenationOfAllWordsAnswer1(s, words);
    }

    private static List<Integer> testAnswer2(String s, String[] words) {
        return getSubstringWithConcatenationOfAllWordsAnswer2(s, words);
    }
}
