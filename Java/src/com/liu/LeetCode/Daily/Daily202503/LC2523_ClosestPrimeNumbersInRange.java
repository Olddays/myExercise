package com.liu.LeetCode.Daily.Daily202503;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2523_ClosestPrimeNumbersInRange {

    // Time Limit Exceeded
    private static int[] closestPrimesMy1(int left, int right) {
        int pre = 0;
        int[] result = new int[]{-1, -1};
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (pre != 0) {
                    int diff = i - pre;
                    if (diff < min) {
                        min = diff;
                        result[0] = pre;
                        result[1] = i;
                    }
                }
                pre = i;
            }
        }
        return result;
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Sieve of Eratosthenes
    // Beats 61.60%
    private static int[] closestPrimesAnswer1(int left, int right) {
        boolean[] sieve = new boolean[right + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= right; j += i) {
                    sieve[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minGap = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for (int i = 1; i < primes.size(); i++) {
            int gap = primes.get(i) - primes.get(i - 1);
            if (gap < minGap) {
                minGap = gap;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] leftList = new int[]{
                1,
                19,
                10,
                4,
        };
        int[] rightList = new int[]{
                10000000,
                31,
                19,
                6,
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < leftList.length; i++) {
            startTime = System.currentTimeMillis();
            result = closestPrimesMy1(leftList[i], rightList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("closestPrimes My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < leftList.length; i++) {
            startTime = System.currentTimeMillis();
            result = closestPrimesAnswer1(leftList[i], rightList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("closestPrimes Answer1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
