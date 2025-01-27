package com.liu.LeetCode.Daily.Daily2020501;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC916_WordSubsets {

    // beats 15.70%
    private static List<String> wordSubsetsMy1(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] maxLetterTags = new int[26];
        int[] tempTags = new int[26];
        for (String word : words2) {
            Arrays.fill(tempTags, 0);
            for (char c : word.toCharArray()) {
                tempTags[c - 'a']++;
            }
            for (int i = 0; i < maxLetterTags.length; i++) {
                maxLetterTags[i] = Math.max(maxLetterTags[i], tempTags[i]);
            }
        }
        for (String word1 : words1) {
            boolean isSubset = true;
            tempTags = maxLetterTags.clone();
            for (char c : word1.toCharArray()) {
                tempTags[c - 'a']--;
            }
            for (int count : tempTags) {
                if (count > 0) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) {
                result.add(word1);
            }
        }
        return result;
    }

    // beats 30.23%
    private static List<String> wordSubsetsMy2(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] maxLetterTags = new int[26];
        int[] tempTags = new int[26];
        for (String word : words2) {
            Arrays.fill(tempTags, 0);
            for (char c : word.toCharArray()) {
                tempTags[c - 'a']++;
            }
            for (int i = 0; i < maxLetterTags.length; i++) {
                maxLetterTags[i] = Math.max(maxLetterTags[i], tempTags[i]);
            }
        }
        for (String word1 : words1) {
            boolean isSubset = true;
            Arrays.fill(tempTags, 0);
            for (char c : word1.toCharArray()) {
                tempTags[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (maxLetterTags[i] > tempTags[i]) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) {
                result.add(word1);
            }
        }
        return result;
    }

    // beats 30.23%
    private static List<String> wordSubsetsMy3(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] maxLetterTags = new int[26];
        int[] tempTags = new int[26];
        for (String word : words2) {
            Arrays.fill(tempTags, 0);
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                tempTags[i]++;
                maxLetterTags[i] = Math.max(maxLetterTags[i], tempTags[i]);
            }
        }
        for (String word1 : words1) {
            boolean isSubset = true;
            Arrays.fill(tempTags, 0);
            for (char c : word1.toCharArray()) {
                tempTags[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (maxLetterTags[i] > tempTags[i]) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) {
                result.add(word1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] words1List = new String[][]{
                {"amazon", "apple", "facebook", "google", "leetcode"},
                {"amazon", "apple", "facebook", "google", "leetcode"},
                {"amazon", "apple", "facebook", "google", "leetcode"},
                {"amazon", "apple", "facebook", "google", "leetcode"},
        };
        String[][] words2List = new String[][]{
                {"e", "oo"},
                {"lo", "eo"},
                {"e", "o"},
                {"l", "e"},
        };
        List<String> result;
        long startTime;
        long endTime;

        for (int i = 0; i < words1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = wordSubsetsMy1(words1List[i], words2List[i]);
            endTime = System.currentTimeMillis();
            System.out.print("wordSubsets My1 result" + i + " ");
            for (String s : result) {
                System.out.print(s + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < words1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = wordSubsetsMy2(words1List[i], words2List[i]);
            endTime = System.currentTimeMillis();
            System.out.print("wordSubsets My2 result" + i + " ");
            for (String s : result) {
                System.out.print(s + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < words1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = wordSubsetsMy3(words1List[i], words2List[i]);
            endTime = System.currentTimeMillis();
            System.out.print("wordSubsets My3 result" + i + " ");
            for (String s : result) {
                System.out.print(s + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
