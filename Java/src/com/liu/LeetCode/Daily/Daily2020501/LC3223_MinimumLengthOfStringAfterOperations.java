package com.liu.LeetCode.Daily.Daily2020501;

public class LC3223_MinimumLengthOfStringAfterOperations {

    private static int minimumLengthMy1(String s) {
        int result = 0;
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        for (int count : letters) {
            if (count >= 3) {
                if (count % 2 == 1) {
                    result += 1;
                } else {
                    result += 2;
                }
            } else {
                result += count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "abaacbcbb",
                "aa",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minimumLengthMy1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minimumLength My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
