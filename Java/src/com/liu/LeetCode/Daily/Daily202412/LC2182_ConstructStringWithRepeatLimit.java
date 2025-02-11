package com.liu.LeetCode.Daily.Daily202412;

import java.util.*;

public class LC2182_ConstructStringWithRepeatLimit {

    private static String repeatLimitedStringAnswer1(String s, int repeatLimit) {
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> b - a);
        for (char ch : s.toCharArray()) {
            pq.add(ch);
        }
        StringBuilder res = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        int count = 0;
        char previouschar = pq.peek();
        while (!pq.isEmpty()) {
            char curr = pq.poll();
            if (curr == previouschar) {
                if (count < repeatLimit) {
                    res.append(curr);
                } else {
                    stk.add(curr);
                }
                count++;
            } else {
                if (stk.isEmpty()) {
                    count = 0;
                    res.append(curr);
                    previouschar = curr;
                    count++;
                } else {
                    res.append(curr);
                    count = 0;
                    while (!stk.isEmpty() && count < repeatLimit) {
                        res.append(stk.pop());
                        count++;
                    }
                }
            }
        }
        return res.toString();
    }

    private static String repeatLimitedStringAnswer2(String s, int repeatLimit) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder result = new StringBuilder();

        int freq = 1;
        int pointer = chars.length - 1;

        for (int i = chars.length - 1; i >= 0; --i) {
            if (result.length() > 0 && result.charAt(result.length() - 1) == chars[i]) {
                if (freq < repeatLimit) {
                    result.append(chars[i]);
                    freq++;
                } else {
                    while (pointer >= 0 && (chars[pointer] == chars[i] || pointer > i)) {
                        pointer--;
                    }

                    if (pointer >= 0) {
                        result.append(chars[pointer]);
                        char temp = chars[i];
                        chars[i] = chars[pointer];
                        chars[pointer] = temp;
                        freq = 1;
                    } else {
                        break;
                    }
                }
            } else {
                result.append(chars[i]);
                freq = 1;
            }
        }
        return result.toString();
    }

    private static String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int pendingLetterIndex = -1;
        StringBuilder sb = new StringBuilder();

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0)
                continue;

            if (pendingLetterIndex > 0) {
                sb.append((char) ('a' + i));
                freq[i]--;
                i = pendingLetterIndex;
                pendingLetterIndex = -1;

            } else {
                for (int j = 0; j < repeatLimit && freq[i] > 0; j++, freq[i]--)
                    sb.append((char) ('a' + i));

                if (freq[i] > 0)
                    pendingLetterIndex = i + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] sSet = new String[]{
                "zzxxccaaa",
                "cczazcc",
                "aababab",
        };
        int[] repeatLimitSet = new int[]{
                2,
                3,
                2,
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = repeatLimitedStringAnswer1(sSet[i], repeatLimitSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("repeatLimitedString Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = repeatLimitedStringAnswer2(sSet[i], repeatLimitSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("repeatLimitedString Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

    }
}
