package com.liu.LeetCode.First.test;

import java.util.ArrayList;
import java.util.List;

import static com.liu.LeetCode.First.exercise.LC126_WordLadderII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC126_WordLadderIITest {

    public static void main(String[] args) {
        String beginWord =
                "hit";
        String endWord =
                "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        long startTime;
        List<List<String>> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(beginWord, endWord, wordList);
        endTime = System.currentTimeMillis();
        System.out.println("WordLadderII Answer 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        startTime = System.currentTimeMillis();
        result = testAnswer2(beginWord, endWord, wordList);
        endTime = System.currentTimeMillis();
        System.out.println("WordLadderII Answer 2 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static List<List<String>> testAnswer1(String beginWord, String endWord, List<String> wordList) {
        return getWordLadderIIAnswer1(beginWord, endWord, wordList);
    }

    private static List<List<String>> testAnswer2(String beginWord, String endWord, List<String> wordList) {
        return getWordLadderIIAnswer2(beginWord, endWord, wordList);
    }
}
