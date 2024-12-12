package com.liu.LeetCode.CodeCaprice.String.KMP;

public class LC459_RepeatedSubstringPattern {

    // Time Limit Exceeded replaceAll的性能太差了
    private static boolean repeatedSubstringPatternMy1(String s) {
        int length = s.length();
        if (length == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        char start = chars[0];
        String cache = "" + start;
        for (int i = 1; i < length / 2 + 1; i++) {
            if (chars[i] == start) {
                if (s.replaceAll(cache, "").length() == 0) {
                    return true;
                }
            }
            cache = cache + chars[i];
        }
        return false;
    }

    // 移动子串
    private static boolean repeatedSubstringPatternAnswer1(String s) {
        int length = s.length();
        if (length == 0) {
            return false;
        }
        for (int i = 1; i <= length / 2; i++) {
            if (length % i != 0) {
                continue;
            }
            String subString = s.substring(0, i);
            boolean cache = true;
            for (int j = i; j <= length - i; j += i) {
                String nextSub = s.substring(j, j + i);
                if (!subString.equals(nextSub)) {
                    cache = false;
                    break;
                }
            }
            if (cache) {
                return true;
            }
        }
        return false;
    }

    // KMP 最小重复单位，就是最长相等前后缀不包含的那部分子串
    // 所以核心是求next数组，然后用length减next数组的最后一个值，如果这个数字能被length整除，那就说明返回true
    private static boolean repeatedSubstringPatternAnswer2(String s) {
        int length = s.length();
        int[] next = new int[length];
        next[0] = 0;
        int j = 0; // 前缀末尾、i包括i之前的最长子串的末尾
        int i = 1; // 后缀末尾
        for (; i < length; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) { // 遇见冲突看前一位的next值，冲突不变量
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        int minRepeat = length - next[length - 1];
        if (minRepeat == length || minRepeat == 0) {
            return false;
        }
        return length % minRepeat == 0;
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "babbabbabbabbab",
                "abab",
                "ababab",
                "abaaba",
                "aba",
                "abcabcabcabc",
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = repeatedSubstringPatternMy1(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("repeatedSubstringPattern My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = repeatedSubstringPatternAnswer1(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("repeatedSubstringPattern Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = repeatedSubstringPatternAnswer2(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("repeatedSubstringPattern Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
