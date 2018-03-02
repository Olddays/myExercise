package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC204_CountPrimes {
    /**
     * Description:
     * <p>
     * Count the number of prime numbers less than a non-negative number, n.
     * <p>
     * Credits:
     * Special thanks to @mithmatt for adding this problem and creating all test cases.
     */

    // O(n²)时间复杂度太高
    public static int getCountPrimesMy1(int n) {
        int result = 0;
        for (int i = 2; i < n; i++) {
            int cache = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cache++;
                }
            }
            if (cache <= 2) {
                result++;
            }
        }
        return result;
    }

    public static int getCountPrimesAnswer1(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true; // 每发现一个质数,就将其所有小于n的倍数全部进行置位
                }
            }
        }
        return count;
    }
}
