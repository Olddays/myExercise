package com.liu.LeetCode.Daily.Daily202412;

import java.util.Arrays;

public class LC2054_TwoBestNon_OverlappingEvents {

    private static int maxTwoEventsAnswer1(int[][] events) {
        int n = events.length;

        // Step 1: Sort the events by their start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Step 2: Create the suffix array for the maximum event value from each event onward
        int[] suffixMax = new int[n];

        suffixMax[n - 1] = events[n - 1][2];  // Initialize the last event's value
        // Populate the suffixMax array
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
        }

        // Step 3: For each event, find the next event that starts after it ends
        int maxSum = 0;
        int left;
        int right;
        int nextEventIndex;
        for (int i = 0; i < n; i++) {
            left = i + 1;
            right = n - 1;
            nextEventIndex = -1;

            // Perform binary search to find the next non-overlapping event
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > events[i][1]) {
                    nextEventIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // If a valid next event is found, update the max sum
            if (nextEventIndex != -1) {
                maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextEventIndex]);
            }

            // Also consider the case where we take only the current event
            maxSum = Math.max(maxSum, events[i][2]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][][] eventsSet = new int[][][]{
                {
                        {1, 3, 2},
                        {4, 5, 2},
                        {2, 4, 3}
                },
                {
                        {1, 3, 2},
                        {4, 5, 2},
                        {1, 5, 5}
                },
                {
                        {1, 5, 2},
                        {1, 5, 1},
                        {6, 6, 5}
                },
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < eventsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxTwoEventsAnswer1(eventsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxTwoEvents My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
