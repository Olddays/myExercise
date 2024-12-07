package com.liu.LeetCode.CodeCaprice.String;

public class LC151_ReverseWordsInAString {

    // 性能还行，Beats61.75%
    private static String reverseWordsMy1(String s) {
        String[] cache = s.trim().split("\\s+");
        int left = 0;
        int right = cache.length - 1;
        while (left < right) {
            String temp = cache[left];
            cache[left] = cache[right];
            cache[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", cache);
    }

    // 性能更差，Beats21.14%
    private static String reverseWordsMy2(String s) {
        String[] cache = s.trim().split("\\s+");
        String result = "";
        for (int i = cache.length - 1; i > 0; i--) {
            result += cache[i] + " ";
        }
        return result + cache[0];
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "the sky is blue",
                "  hello world  ",
                "a good   example",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = reverseWordsMy1(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("reverseWords My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = reverseWordsMy2(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("reverseWords My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
