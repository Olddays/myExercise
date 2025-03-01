package com.liu.LeetCode.Daily.Daily202502;

import java.util.*;

public class LC873_LengthOfLongestFibonacciSubsequence {

    // Brute Force
    // Limit Timed Execution
    private static int lenLongestFibSubseqAnswer1(int[] arr) {
        int n = arr.length;
        // Store array elements in set for O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int maxLen = 0;
        // Try all possible first two numbers of sequence
        for (int start = 0; start < n; ++start) {
            for (int next = start + 1; next < n; ++next) {
                // Start with first two numbers
                int prev = arr[next];
                int curr = arr[start] + arr[next];
                int len = 2;

                // Keep finding next Fibonacci number
                while (numSet.contains(curr)) {
                    // Update values for next iteration
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    maxLen = Math.max(maxLen, ++len);
                }
            }
        }

        return maxLen;
    }

    // Dynamic Programming
    // Beats 25.74%
    private static int lenLongestFibSubseqAnswer2(int[] arr) {
        int maxLen = 0;
        // dp[prev][curr] stores length of Fibonacci sequence ending at indexes prev,curr
        int[][] dp = new int[arr.length][arr.length];

        // Map each value to its index for O(1) lookup
        Map<Integer, Integer> valToIdx = new HashMap<>();

        // Fill dp array
        for (int curr = 0; curr < arr.length; curr++) {
            valToIdx.put(arr[curr], curr);

            for (int prev = 0; prev < curr; prev++) {
                // Find if there exists a previous number to form Fibonacci sequence
                int diff = arr[curr] - arr[prev];
                int prevIdx = valToIdx.getOrDefault(diff, -1);

                // Update dp if valid Fibonacci sequence possible
                // diff < arr[prev] ensures strictly increasing sequence
                if (diff < arr[prev] && prevIdx >= 0) {
                    dp[prev][curr] = dp[prevIdx][prev] + 1;
                } else {
                    dp[prev][curr] = 2;
                }

                maxLen = Math.max(maxLen, dp[prev][curr]);
            }
        }

        // Return 0 if no sequence of length > 2 found
        return maxLen > 2 ? maxLen : 0;
    }

    // Optimized Dynamic Programming
    // 对于dp[i][j]表示arr[i]和arr[j]表示斐波那契数列的最后两个数
    // 因为这两个值是key，可以唯一定义一个斐波那契数列
    // 比如[1,3,4,7],那么[...,7,11]就比[..,4,7]多1，也就是7,11结尾比4,7结尾多1，所以可以唯一定义一个斐波那契数列
    // Beats 97.34%
    private static int lenLongestFibSubseqAnswer3(int[] arr) {
        int n = arr.length;
        // dp[prev][curr] stores length of Fibonacci sequence ending at indexes prev,curr
        int[][] dp = new int[n][n];
        int maxLen = 0;

        // Find all possible pairs that sum to arr[curr]
        for (int curr = 2; curr < n; curr++) {
            // Use two pointers to find pairs that sum to arr[curr]
            int start = 0;
            int end = curr - 1;

            while (start < end) {
                int pairSum = arr[start] + arr[end];

                if (pairSum > arr[curr]) {
                    end--;
                } else if (pairSum < arr[curr]) {
                    start++;
                } else {
                    // Found a valid pair, update dp
                    dp[end][curr] = dp[start][end] + 1;
                    maxLen = Math.max(dp[end][curr], maxLen);
                    end--;
                    start++;
                }
            }
        }

        // Add 2 to include first two numbers, or return 0 if no sequence found
        return maxLen == 0 ? 0 : maxLen + 2;
    }

    public static void main(String[] args) {
        int[][] arrList = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8},
                {1, 3, 7, 11, 12, 14, 18},
                {1, 3, 5},
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = lenLongestFibSubseqAnswer1(arrList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lenLongestFibSubseq Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = lenLongestFibSubseqAnswer2(arrList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lenLongestFibSubseq Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = lenLongestFibSubseqAnswer3(arrList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lenLongestFibSubseq Answer3 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
