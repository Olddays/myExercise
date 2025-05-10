package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC1399_CountLargestGroup {

    // force brute
    // Beats 95.34%
    private static int countLargestGroupMy1(int n) {
        int[] counts = new int[37]; // n最大值是10000，所以digits sum最大值是n=9999的时候，也就是36
        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            int digitsSum = 0;
            int num = i;
            while (num > 0) {
                digitsSum += num % 10;
                num /= 10;
            }
            counts[digitsSum]++;
            maxCount = Math.max(maxCount, counts[digitsSum]);
        }
        int result = 0;
        for (int count : counts) {
            if (count == maxCount) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                13,
                2,
        };
        int[] resultList = new int[]{
                4,
                2,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countLargestGroupMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countLargestGroup My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
