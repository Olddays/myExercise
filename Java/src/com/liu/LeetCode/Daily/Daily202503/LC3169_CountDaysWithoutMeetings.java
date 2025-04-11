package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC3169_CountDaysWithoutMeetings {

    // Beats 35.02%
    private static int countDaysMy1(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int freeDays = 0;
        int lastEnd = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > lastEnd) {
                freeDays += meeting[0] - 1 - lastEnd;
            }
            lastEnd = Math.max(lastEnd, meeting[1]);
        }
        if (lastEnd < days) {
            freeDays += days - lastEnd;
        }
        return freeDays;
    }

    public static void main(String[] args) {
        int[] daysList = new int[]{
                8,
                5,
                10,
                6,
        };
        int[][][] meetingsList = new int[][][]{
                {{3, 4}, {4, 8}, {2, 5}, {3, 8}},
                {{2, 4}, {1, 3}},
                {{5, 7}, {1, 3}, {9, 10}},
                {{1, 6}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < daysList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countDaysMy1(daysList[i], meetingsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countDays My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
