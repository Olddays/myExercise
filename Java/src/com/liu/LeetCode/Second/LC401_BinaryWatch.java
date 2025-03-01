package com.liu.LeetCode.Second;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC401_BinaryWatch {

    private static final int[] HOUR = {8, 4, 2, 1};
    private static final int[] MINUTE = {32, 16, 8, 4, 2, 1};

    // 非常讨巧
    private static List<String> readBinaryWatchAnswer1(int turnedOn) {
        ArrayList<String> result = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    if (minute < 10) result.add(String.format("%d:0%d", hour, minute));
                    else result.add(String.format("%d:%d", hour, minute));
                }
            }
        }
        return result;
    }

    // Beats 87.71%
    public static void main(String[] args) {
        int[] turnedOnSet = {
                1,
                9,
        };
        long startTime;
        List<String> result;
        long endTime;

        for (int i = 0; i < turnedOnSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = readBinaryWatchAnswer1(turnedOnSet[i]);
            endTime = System.currentTimeMillis();

            System.out.print("readBinaryWatch Answer1 result" + i + " ");
            for (String num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
