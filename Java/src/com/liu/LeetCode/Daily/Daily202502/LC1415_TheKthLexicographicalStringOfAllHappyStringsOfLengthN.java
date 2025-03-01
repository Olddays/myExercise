package com.liu.LeetCode.Daily.Daily202502;

import java.util.*;

public class LC1415_TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    // Beats 83.83%
    private static String getHappyStringMy1(int n, int k) {
        List<String> result = new ArrayList<>();
        backtrackMy1(result, new StringBuilder(), n, k, ' ');
        if (result.size() < k) {
            return "";
        }
        return result.get(k - 1);
    }

    private static final char[] chars = {'a', 'b', 'c'};

    private static void backtrackMy1(List<String> result, StringBuilder stringBuilder, int n, int k, char pre) {
        if (result.size() >= k) {
            return;
        }
        if (stringBuilder.length() == n) {
            result.add(stringBuilder.toString());
            return;
        }
        for (char c : chars) {
            if (c == pre) {
                continue;
            }
            stringBuilder.append(c);
            backtrackMy1(result, stringBuilder, n, k, c);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                1,
                1,
                3,
        };
        int[] kList = new int[]{
                3,
                4,
                9,
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = getHappyStringMy1(nList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("getHappyString My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
