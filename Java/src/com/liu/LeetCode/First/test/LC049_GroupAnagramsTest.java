package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC049_GroupAnagrams.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC049_GroupAnagramsTest {

    public static void main(String[] args) {
        String[] strs = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        long startTime;
        List<List<String>> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(strs);
        endTime = System.currentTimeMillis();
        System.out.println("GroupAnagrams My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        startTime = System.currentTimeMillis();
        result = testMy2(strs);
        endTime = System.currentTimeMillis();
        System.out.println("GroupAnagrams My 2 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static List<List<String>> testMy1(String[] strs) {
        return getGroupAnagramsMy1(strs);
    }

    private static List<List<String>> testMy2(String[] strs) {
        return getGroupAnagramsMy2(strs);
    }
}
