package com.liu.LeetCode.ThirtyDays202007.test;

import java.util.ArrayList;
import java.util.List;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD30_WordBreakII.wordBreakAnswer1;
import static com.liu.LeetCode.ThirtyDays202007.exercise.TD30_WordBreakII.wordBreakMy1;

/**
 * Created by Liu on 2020/7/30.
 */
public class TD30_WordBreakII_Test {

    public static void main(String[] args) {
        String s;
        List<String> wordDict;
        List<String> result;
        long startTime;
        long endTime;


        s = "catsanddog";
        wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        startTime = System.currentTimeMillis();
        result = testMy1(s, wordDict);
        endTime = System.currentTimeMillis();
        System.out.println("TD30_WordBreakII My 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();

        s = "pineapplepenapple";
        wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        startTime = System.currentTimeMillis();
        result = testMy1(s, wordDict);
        endTime = System.currentTimeMillis();
        System.out.println("TD30_WordBreakII My 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();

        s = "catsandog";
        wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        startTime = System.currentTimeMillis();
        result = testMy1(s, wordDict);
        endTime = System.currentTimeMillis();
        System.out.println("TD30_WordBreakII My 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();


        s = "catsanddog";
        wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        startTime = System.currentTimeMillis();
        result = testMy1(s, wordDict);
        endTime = System.currentTimeMillis();
        System.out.println("TD30_WordBreakII Answer 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();

        s = "pineapplepenapple";
        wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        startTime = System.currentTimeMillis();
        result = testMy1(s, wordDict);
        endTime = System.currentTimeMillis();
        System.out.println("TD30_WordBreakII My 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();

        s = "catsandog";
        wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        startTime = System.currentTimeMillis();
        result = testMy1(s, wordDict);
        endTime = System.currentTimeMillis();
        System.out.println("TD30_WordBreakII My 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();
    }

    private static List<String> testMy1(String s, List<String> wordDict) {
        return wordBreakMy1(s, wordDict);
    }

    private static List<String> testAnswer1(String s, List<String> wordDict) {
        return wordBreakAnswer1(s, wordDict);
    }

}
