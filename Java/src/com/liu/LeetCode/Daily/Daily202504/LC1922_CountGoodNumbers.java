package com.liu.LeetCode.Daily.Daily202504;

public class LC1922_CountGoodNumbers {
    // 逻辑是对的，但是无法处理越界的情况，
    private static int countGoodNumbersMyError1(long n) {
        long mod = 1_000_000_007;
        long odd = n / 2;
        long even = n - odd;
        // 这里不需要改为 4 * Math.pow(4, odd) * Math.pow(5, even - 1) 是因为题目说允许存在前导0，所以不需要考虑前导0的情况
        long result = (long) (Math.pow(4, odd) * Math.pow(5, even) % mod);
        return (int) result;
    }

    // 问题被转化为大数计算
    // Beats 100.00%
    private static int countGoodNumbersMy1(long n) {
        long mod = 1_000_000_007;
        long odd = n / 2;
        long even = n - odd;
        long oddCount = countGoodNumbersMy1Helper(4, odd, mod) % mod;
        long evenCount = countGoodNumbersMy1Helper(5, even, mod) % mod;
        long result = oddCount;
        if (evenCount > 0) {
            result = (result * evenCount) % mod;
        }
        return (int) result;
    }

    private static long countGoodNumbersMy1Helper(long num, long power, long mod) {
        if (power == 0) {
            return 1;
        }
        long cache = countGoodNumbersMy1Helper(num, power / 2, mod);
        if (power % 2 == 0) {
            return (cache * cache) % mod; // 其实这里num=1所以省略
        } else {
            return (num * cache * cache) % mod;
        }
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                1,
                2,
                3,
                4,
                50,
        };
        int[] resultList = new int[]{
                5,
                20,
                100,
                400,
                564908303,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countGoodNumbersMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countGoodNumbers My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
