package com.liu.LeetCode.CodeCaprice.String;

public class LC541_ReverseStringII {

    // 没问题，但是性能不行，Beats19.62%
    private static String reverseStrMy1(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i += 2 * k) {
            char[] cache = s.substring(i, Math.min(i + k, length)).toCharArray();
            int left = 0;
            int right = cache.length - 1;
            while (left < right) {
                char tmp = cache[left];
                cache[left] = cache[right];
                cache[right] = tmp;
                left++;
                right--;
            }
            sb.append(cache);
            sb.append(s, Math.min(i + k, length), Math.min(i + 2 * k, length));
        }
        return sb.toString();
    }

    // Beats71.89%，所以stringbuilder性能比较差
    private static String reverseStrMy2(String s, int k) {
        char[] cache = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < length; i += 2 * k) {
            int left = i;
            int right = i + k - 1;
            if (right >= length) {
                right = length - 1;
            }
            while (left < right) {
                char tmp = cache[left];
                cache[left] = cache[right];
                cache[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(cache);
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "abcdefg",
                "a",
                "abcdefg",
                "abcdefg",
                "abcd",
        };
        int[] kSet = new int[]{
                8,
                2,
                3,
                2,
                2,
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = reverseStrMy1(sSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("reverseStr My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = reverseStrMy2(sSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("reverseStr My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
