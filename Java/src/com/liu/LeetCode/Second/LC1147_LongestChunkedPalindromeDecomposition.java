package com.liu.LeetCode.Second;

public class LC1147_LongestChunkedPalindromeDecomposition {

    private static int longestDecompositionMy1(String text) {
        return 0;
    }

    public static void main(String[] args) {
        String[] textSet = new String[]{
                "ghiabcdefhelloadamhelloabcdefghi",
                "merchant",
                "antaprezatepzapreanta",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < textSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = longestDecompositionMy1(textSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("longestDecomposition My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
