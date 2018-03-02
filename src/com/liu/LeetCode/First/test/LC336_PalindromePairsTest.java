package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC336_PalindromePairs.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC336_PalindromePairsTest {

    public static void main(String[] args) {
        String[][] wordsList = {
                {"bat", "tab", "cat"},
                {"abcd", "dcba", "lls", "s", "sssll"},
                {"a", ""}
        };
        long startTime;
        List<List<Integer>> result;
        long endTime;

        for (String[] words : wordsList) {
            startTime = System.currentTimeMillis();
            result = testMy1(words);
            endTime = System.currentTimeMillis();
            System.out.println("PalindromePairs My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (List<Integer> list : result) {
                for (int i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println();

            startTime = System.currentTimeMillis();
            result = testMy2(words);
            endTime = System.currentTimeMillis();
            System.out.println("PalindromePairs My 2 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (List<Integer> list : result) {
                for (int i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println();

            startTime = System.currentTimeMillis();
            result = testAnswer1(words);
            endTime = System.currentTimeMillis();
            System.out.println("PalindromePairs Answer 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (List<Integer> list : result) {
                for (int i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println();

            startTime = System.currentTimeMillis();
            result = testAnswer2(words);
            endTime = System.currentTimeMillis();
            System.out.println("PalindromePairs Answer 2 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (List<Integer> list : result) {
                for (int i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> testMy1(String[] words) {
        return getPalindromePairsMy1(words);
    }

    private static List<List<Integer>> testMy2(String[] words) {
        return getPalindromePairsMy2(words);
    }

    private static List<List<Integer>> testAnswer1(String[] words) {
        return getPalindromePairsAnswer1(words);
    }

    private static List<List<Integer>> testAnswer2(String[] words) {
        return getPalindromePairsAnswer2(words);
    }
}
