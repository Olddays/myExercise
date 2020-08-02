package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/15.
 */
public class TD15_ReverseWordsInAString {
    public static String reverseWordsMy1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] parts = s.trim().split(" ");
        String result = "";
        for (int i = parts.length - 1; i >= 0; i--) {
            if (parts[i].equals("")) {
                continue;
            }
            result += parts[i] + " ";
        }
        result = result.trim();
        return result;
    }

    public static String reverseWordsMy2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();

        String result = "";
        String cache = "";
        for (char c : chars) {
            if (c == ' ') {
                if (cache.length() > 0) {
                    if (result.length() == 0) {
                        result = cache;
                    } else {
                        result = cache + " " + result;
                    }
                    cache = "";
                }
            } else {
                cache += c;
            }
        }
        if (cache.length() > 0) {
            if (result.length() == 0) {
                result = cache;
            } else {
                result = cache + " " + result;
            }
        }
        return result;
    }

    public static String reverseWordsAnswer1(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    // reverse a[] from a[i] to a[j]
    private static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

   private static void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    private static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }
}
