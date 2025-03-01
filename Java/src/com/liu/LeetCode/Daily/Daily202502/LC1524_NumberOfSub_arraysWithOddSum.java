package com.liu.LeetCode.Daily.Daily202502;

import java.util.*;

public class LC1524_NumberOfSub_arraysWithOddSum {

    // 估计会超时
    // 不能用回溯，是子数组不是子集合，应该用双指针和dp
    private static int numOfSubarraysMyError1(int[] arr) {
        List<Integer> subarrays = new ArrayList<>();
        backtrackMy1(subarrays, new ArrayList<>(), arr, 0);
        int oddCount = 0;
        for (int i : subarrays) {
            if (i % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount;
    }

    private static void backtrackMy1(List<Integer> subarrays, List<Integer> cache, int[] arr, int begin) {
        if (!cache.isEmpty()) {
            int sum = 0;
            for (int i : cache) {
                sum += i;
            }
            subarrays.add(sum);
        }
        for (int i = begin; i < arr.length; i++) {
            cache.add(arr[i]);
            backtrackMy1(subarrays, cache, arr, i + 1);
            cache.remove(cache.size() - 1);
        }
    }

    // 超时 Time Limit Exceeded
    private static int numOfSubarraysMy1(int[] arr) {
        int length = arr.length;
        boolean[][] dpIsOdd = new boolean[length][length];
        int oddCount = 0;
        for (int i = 0; i < length; i++) {
            dpIsOdd[i][i] = arr[i] % 2 != 0;
            if (dpIsOdd[i][i]) {
                oddCount++;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[j] % 2 == 0) {
                    dpIsOdd[i][j] = dpIsOdd[i][j - 1];
                } else {
                    dpIsOdd[i][j] = !dpIsOdd[i][j - 1];
                }
                if (dpIsOdd[i][j]) {
                    oddCount++;
                }
            }
        }
        return oddCount;
    }

    // 前缀和
    private static int numOfSubarraysAnswer1(int[] arr) {
        long oddCount = 0;
        long prefixSum = 0;
        for (int a : arr) {
            prefixSum += a;
            oddCount += prefixSum % 2;
        }
        // 此时，oddCount 为所有奇数子数组的和，arr.length-oddCount 为所有偶数子数组的和
        // 对于每个偶数子数组，其前面的奇数子数组都可以与其组成新的奇数子数组
        oddCount += (arr.length - oddCount) * oddCount;
        return (int) (oddCount % 1_000_000_007);
    }

    // 把前缀和算法拆开
    private static int numOfSubarraysAnswer2(int[] arr) {
        final int MODULO = 1000000007;
        int odd = 0, even = 1;
        int subarrays = 0;
        int sum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            subarrays = (subarrays + (sum % 2 == 0 ? odd : even)) % MODULO;
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        int[][] arrList = new int[][]{
                {1, 3, 5},
                {2, 4, 6},
                {1, 2, 3, 4, 5, 6, 7},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numOfSubarraysMy1(arrList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numOfSubarrays My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numOfSubarraysAnswer1(arrList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numOfSubarrays Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numOfSubarraysAnswer2(arrList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numOfSubarrays Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
