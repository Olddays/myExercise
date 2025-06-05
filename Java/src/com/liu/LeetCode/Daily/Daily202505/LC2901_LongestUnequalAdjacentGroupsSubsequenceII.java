package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC2901_LongestUnequalAdjacentGroupsSubsequenceII {

    // 任意一个位置出发，找到汉明距离均为1的最长子串，其实可以理解为一个图
    // 先试试贪心 Error,默认用第一个word作为起点是不对的
    private static List<String> getWordsInLongestSubsequenceMyError1(String[] words, int[] groups) {
        int length = words.length;
        List<Integer>[] lengthList = new List[11]; // 1 <= words[i].length <= 10
        List<Integer> maxList = null;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int group = groups[i];
            List<Integer> list = lengthList[word.length()];
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                lengthList[word.length()] = list;
            } else {
                int lastIndex = list.get(list.size() - 1);
                String lastWord = words[lastIndex];
                int lastGroup = groups[lastIndex];
                if (lastGroup != group) {
                    if (hammingDistanceCount(lastWord, word) == 1) {
                        list.add(i);
                    }
                }
            }
            if (maxList == null || list.size() > maxList.size()) {
                maxList = list;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i : maxList) {
            result.add(words[i]);
        }
        return result;
    }

    // Beats 43.90%
    private static List<String> getWordsInLongestSubsequenceMy1(String[] words, int[] groups) {
        int length = words.length;
        int[] dp = new int[length];
        int[] parent = new int[length];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxi = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && dp[i] < dp[j] + 1 &&
                        (hammingDistanceCount(words[i], words[j])) == 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxi) maxi = dp[i];
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (dp[i] == maxi) {
                while (i != -1) {
                    result.add(words[i]);
                    i = parent[i];
                }
                break;
            }
        }
        Collections.reverse(result);
        return result;
    }

    private static int hammingDistanceCount(String word1, String word2) {
        int result = 0;
        if (word1.length() != word2.length()) {
            return result;
        }
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] wordsList = new String[][]{
                {"bdb", "aaa", "ada"},
                {"bab", "dab", "cab"},
                {"a", "b", "c", "d"},
        };
        int[][] groupsList = new int[][]{
                {2, 1, 3},
                {1, 2, 2},
                {1, 2, 3, 4},
        };
        List<String>[] resultList = new List[]{
                new ArrayList<String>() {{
                    add("bab");
                    add("cab");
                }},
                new ArrayList<String>() {{
                    add("a");
                    add("b");
                    add("c");
                    add("d");
                }},
        };
        List<String> result;
        long startTime;
        long endTime;

        for (int i = 0; i < wordsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = getWordsInLongestSubsequenceMy1(wordsList[i], groupsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("getWordsInLongestSubsequence My1 result" + i + " " + Arrays.toString(result.toArray()) + " result check "
                    + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
