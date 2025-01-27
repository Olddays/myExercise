package com.liu.LeetCode.Daily.Daily2020501;

public class LC2185_CountingWordsWithAGivenPrefix {

    private static int prefixCountMy1(String[] words, String pref) {
        int result = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] wordsList = new String[][]{
                {"pay", "attention", "practice", "attend"},
                {"leetcode", "win", "loops", "success"},
        };
        String[] prefList = new String[]{
                "at",
                "code",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < wordsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = prefixCountMy1(wordsList[i], prefList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("prefixCount My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
