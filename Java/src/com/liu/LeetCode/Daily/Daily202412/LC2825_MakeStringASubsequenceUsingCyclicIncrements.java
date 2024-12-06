package com.liu.LeetCode.Daily.Daily202412;

public class LC2825_MakeStringASubsequenceUsingCyclicIncrements {

    private static boolean canMakeSubsequenceAnswer1(String str1, String str2) {
        int matchLength = 0;
        int targetLength = str2.length();
        for (char currentChar : str1.toCharArray()) {
            if (matchLength < targetLength) {
                char targetChar = str2.charAt(matchLength);
                if ((targetChar - currentChar + 26) % 26 <= 1) {
                    matchLength++;
                }
            }
        }
        return matchLength == targetLength;
    }

    public static void main(String[] args) {
        String[] str1List = new String[]{
                "abc",
                "zc",
                "ab",
        };
        String[] str2List = new String[]{
                "ad",
                "ad",
                "d",
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < str1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = canMakeSubsequenceAnswer1(str1List[i], str2List[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canMakeSubsequence Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
