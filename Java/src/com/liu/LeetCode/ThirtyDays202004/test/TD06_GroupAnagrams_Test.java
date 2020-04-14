package com.liu.LeetCode.ThirtyDays202004.test;

import java.util.List;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD06_GroupAnagrams.groupAnagrams;

public class TD06_GroupAnagrams_Test {

    public static void main(String[] args) {
        String[] strs;
        List<List<String>> result;
        long startTime;
        long endTime;

        strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        startTime = System.currentTimeMillis();
        result = testMy1(strs);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_GroupAnagrams My 1 result: ");
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println("during time " + (endTime - startTime));

        strs = new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        startTime = System.currentTimeMillis();
        result = testMy1(strs);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_GroupAnagrams My 1 result: ");
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println("during time " + (endTime - startTime));

        strs = new String[]{"tao", "pit", "cam", "aid", "pro", "dog"};
        startTime = System.currentTimeMillis();
        result = testMy1(strs);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_GroupAnagrams My 1 result: ");
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println("during time " + (endTime - startTime));
    }

    private static List<List<String>> testMy1(String[] strs) {
        return groupAnagrams(strs);
    }
}
