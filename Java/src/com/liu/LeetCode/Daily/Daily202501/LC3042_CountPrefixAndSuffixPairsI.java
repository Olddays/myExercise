package com.liu.LeetCode.Daily.Daily202501;

public class LC3042_CountPrefixAndSuffixPairsI {

    private static int countPrefixSuffixPairsMy1(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] sList = new String[][]{
                {"a", "aba", "ababa", "aa"},
                {"pa", "papa", "ma", "mama"},
                {"abab", "ab"},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countPrefixSuffixPairsMy1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countPrefixSuffixPairs My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
