package com.liu.LeetCode.Daily.Daily202501;

import java.util.*;

public class LC1408_StringMatchingInAnArray {

    private static List<String> stringMatchingMy1(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i]) && !result.contains(words[i])) {
                    result.add(words[i]);
                }
            }
        }
        return result;
    }

    // 很聪明的方法
    private static List<String> stringMatchingAnswer1(String[] words) {
        String str = String.join(" ", words);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (str.indexOf(word) != str.lastIndexOf(word)) {
                res.add(word);
            }
        }
        return res;
    }

    // TODO 需要再学一下KMP算法并实现

    public static void main(String[] args) {
        String[][] sList = new String[][]{
                {"leetcoder", "leetcode", "od", "hamlet", "am"},
                {"mass", "as", "hero", "superhero"},
                {"leetcode", "et", "code"},
                {"blue", "green", "bu"},
        };
        List<String> result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = stringMatchingMy1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("stringMatching My1 result" + i + " ");
            for (String s : result) {
                System.out.print(s + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = stringMatchingAnswer1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("stringMatching Answer1 result" + i + " ");
            for (String s : result) {
                System.out.print(s + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
