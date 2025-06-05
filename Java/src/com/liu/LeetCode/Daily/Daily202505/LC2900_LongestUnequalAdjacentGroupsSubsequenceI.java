package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC2900_LongestUnequalAdjacentGroupsSubsequenceI {

    // simple greedy
    // 无论如何都不会出现选了一个导致后面选的变少的情况，比如选了个0，无论后面跟着多少个0，结果都是这些0里面只能选一个，所以选第一个和最后一个都一样
    // Beats 96.15%
    private static List<String> getLongestSubsequenceMy1(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int length = words.length;
        int lastGroup = groups[0];
        result.add(words[0]);
        for (int i = 1; i < length; i++) {
            if (groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] wordsList = new String[][]{
                {"e", "a", "b"},
                {"a", "b", "c", "d"},
        };
        int[][] groupsList = new int[][]{
                {0, 0, 1},
                {1, 0, 1, 1},
        };
        List<String>[] resultList = new List[]{
                new ArrayList<String>() {{
                    add("e");
                    add("b");
                }},
                new ArrayList<String>() {{
                    add("a");
                    add("b");
                    add("c");
                }},
        };
        List<String> result;
        long startTime;
        long endTime;

        for (int i = 0; i < wordsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = getLongestSubsequenceMy1(wordsList[i], groupsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("getLongestSubsequence My1 result" + i + " " + Arrays.toString(result.toArray()) + " result check "
                    + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
