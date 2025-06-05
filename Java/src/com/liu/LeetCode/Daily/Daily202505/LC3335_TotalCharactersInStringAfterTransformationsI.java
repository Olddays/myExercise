package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC3335_TotalCharactersInStringAfterTransformationsI {

    private static long mod_add(long a, long b) {
        final long mod = 1000000007;
        a %= mod;
        b %= mod;
        return ((a + b) % mod + mod) % mod;
    }

    // Beats 6.33%
    private static int lengthAfterTransformationsMy1(String s, int t) {
        long[] nums = new long[26];
        for (char ch : s.toCharArray()) {
            nums[ch - 'a']++;
        }
        while (t-- > 0) {
            long[] cur = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25 && nums[j] > 0) {
                    cur[0] = mod_add(cur[0], nums[j]);
                    cur[1] = mod_add(cur[1], nums[j]);
                } else {
                    if (j < 25) {
                        cur[j + 1] = mod_add(cur[j + 1], nums[j]);
                    }
                }
            }
            nums = cur;
        }
        long cnt = 0;
        for (long i : nums) {
            cnt = mod_add(cnt, i);
        }
        return (int) cnt;
    }

    // Beats 96.20%
    private static int lengthAfterTransformationsAnswer1(String s, int t) {
        long output = 0;
        int MOD = 1_000_000_007;
        int[] charFrequency = new int[26]; // 遇到字母，可以考虑建数组
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }
        Deque<Long> dq = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) dq.offer(1L);
        int counter = 0;
        while (counter++ < t) {
            dq.addLast((dq.pollFirst() + dq.peekFirst()) % MOD);
        }
        List<Long> list = new ArrayList<>(dq);
        for (int i = 0; i < 26; i++) {
            output += (charFrequency[i] * list.get(i));
            output %= MOD;
        }
        return (int) output;
    }

    private static int lengthAfterTransformationsMyError1(String s, int t) {
        int length = s.length();
        int MOD = 1000000007;
        int plus = t / 26; // 每个数字会多出来多少个长度
        t = t % 26;
        int plusCount = 0;
        for (int i = 0; i < length; i++) {
            int current = s.charAt(i) - 'a';
            int next = current + t;
            plusCount += plus;
            if (next >= 26) {
                plusCount++;
            }
        }
        long result;
        // 因为要的是长度，所以可以当作在第一轮遍历后，所有的b都加在字符串的最后面
        if (plusCount > 0 && plus > 0) {
            // 生成了plusCount个'b'
            if (t + 1 >= 26) {
                plus++;
            }
            // 每个b，都会增加plus+plus-1+plus-2+...+1个长度

            result = (long) plus * (plus + 1) / 2 * plusCount + length;
            result %= MOD;
            return (int) result;
        } else {
            result = (long) (length + plusCount);
            result %= MOD;
            return (int) result;
        }
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "jqktcurgdvlibczdsvnsg",
                "abcyy",
                "azbk",
        };
        int[] tList = new int[]{
                7517,
                2,
                1,
        };
        int[] resultList = new int[]{
                79033769,
                7,
                5,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = lengthAfterTransformationsMy1(sList[i], tList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lengthAfterTransformations My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = lengthAfterTransformationsAnswer1(sList[i], tList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lengthAfterTransformations Answer1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
