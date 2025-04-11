package com.liu.LeetCode.Daily.Daily202503;

public class LC1358_NumberOfSubstringsContainingAllThreeCharacters {

    // Beats 91.15%
    private static int numberOfSubstringsMy1(String s) {
        int length = s.length();
        if (length < 3) {
            return 0;
        }
        int count = 0;
        int[] cache = new int[3];
        int left = 0;
        for (int right = 0; right < length; right++) {
            cache[s.charAt(right) - 'a']++;
            while (cache[0] > 0 && cache[1] > 0 && cache[2] > 0) {
                cache[s.charAt(left) - 'a']--;
                left++;
            }
            count += left;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "abcabc",
                "aaacb",
                "abc",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numberOfSubstringsMy1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numberOfSubstrings My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
