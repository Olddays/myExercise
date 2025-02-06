package com.liu.LeetCode.Daily.Daily202501;

public class LC1400_ConstructKPalindromeStrings {
    // Beats 76.62%
    private static boolean canConstructMy1(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        for (int letter : letters) {
            if (letter % 2 == 1) {
                k--;
            }
        }
        return k >= 0;
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "cr",
                "annabelle",
                "leetcode",
                "true",
        };
        int[] kList = new int[]{
                7,
                2,
                3,
                4,
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = canConstructMy1(sList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canConstruct My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
