package com.liu.LeetApp.test;

import java.util.ArrayList;

import static com.liu.LeetApp.exercise.LA006_Anagrams.*;

/**
 * Created by liu on 2016/12/5.
 */
public class LA006_AnagramsTest {

    public static void main(String[] args) {
        String[] input = new String[]{"abc", "bca", "abc", "cba", "abca", "ccc", "ccc", "afk", "kfa"};
        ArrayList<ArrayList<String>> result;
        long startTime;
        long endTime;

        // 方案一引起了空指针crash不进行测试

        startTime = System.currentTimeMillis();
        result = testMy2(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams My 2 result during time " + (endTime - startTime));
        for (ArrayList<String> items : result) {
            System.out.println("getAnagrams My 2 result sets");
            for (String item : items) {
                System.out.println("getAnagrams My 2 result set " + item);
            }
        }

        startTime = System.currentTimeMillis();
        result = testMy3(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams My 3 result during time " + (endTime - startTime));
        for (ArrayList<String> items : result) {
            System.out.println("getAnagrams My 3 result sets");
            for (String item : items) {
                System.out.println("getAnagrams My 3 result set " + item);
            }
        }

        startTime = System.currentTimeMillis();
        result = testMy4(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams My 4 result during time " + (endTime - startTime));
        for (ArrayList<String> items : result) {
            System.out.println("getAnagrams My 4 result sets");
            for (String item : items) {
                System.out.println("getAnagrams My 4 result set " + item);
            }
        }

        startTime = System.currentTimeMillis();
        result = testMy5(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams My 5 result during time " + (endTime - startTime));
        for (ArrayList<String> items : result) {
            System.out.println("getAnagrams My 5 result sets");
            for (String item : items) {
                System.out.println("getAnagrams My 5 result set " + item);
            }
        }

        startTime = System.currentTimeMillis();
        result = testAnswer(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams Answer result during time " + (endTime - startTime));
        for (ArrayList<String> items : result) {
            System.out.println("getAnagrams Answer result sets");
            for (String item : items) {
                System.out.println("getAnagrams Answer result set " + item);
            }
        }

    }

    private static ArrayList<ArrayList<String>> testMy2(String[] input) {
        return anagramsMy2(input);
    }

    private static ArrayList<ArrayList<String>> testMy3(String[] input) {
        return anagramsMy3(input);
    }

    private static ArrayList<ArrayList<String>> testMy4(String[] input) {
        return anagramsMy4(input);
    }

    private static ArrayList<ArrayList<String>> testMy5(String[] input) {
        return anagramsMy5(input);
    }

    private static ArrayList<ArrayList<String>> testAnswer(String[] input) {
        return anagramsAnswer(input);
    }
}
