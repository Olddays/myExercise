package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

public class LC838_PushDominoes {

    // Beats 100.00% 这次完全自己做的
    private static String pushDominoesMy1(String dominoes) {
        int length = dominoes.length();
        char[] chars = dominoes.toCharArray();
        int lastRight = -1;
        int left = 0;
        for (int right = 0; right < length; right++) {
            char c = chars[right];
            if (c == 'L') {
                if (lastRight != -1) {
                    for (int j = lastRight; j < lastRight + (right - lastRight + 1) / 2; j++) {
                        chars[j] = 'R';
                        chars[right - j + lastRight] = 'L';
                    }
                    left = right + 1;
                    lastRight = -1;
                } else {
                    for (; left < right; left++) {
                        chars[left] = 'L';
                    }
                }
            } else if (c == 'R') {
                if (lastRight != -1) {
                    for (int j = lastRight; j < right; j++) {
                        chars[j] = 'R';
                    }
                }
                lastRight = right;
            }
        }
        if (lastRight != -1) {
            for (int j = lastRight; j < length; j++) {
                chars[j] = 'R';
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] dominoesList = new String[]{
                "R.R.L",
                "RR.L",
                ".L.R...LR..L..",
        };
        String[] resultList = new String[]{
                "RRR.L",
                "RR.L",
                "LL.RR.LLRRLL..",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < dominoesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = pushDominoesMy1(dominoesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("pushDominoes My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
