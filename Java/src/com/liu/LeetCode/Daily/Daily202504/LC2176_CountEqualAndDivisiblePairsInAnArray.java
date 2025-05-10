package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC2176_CountEqualAndDivisiblePairsInAnArray {

    // 肯定时对的，但是性能不一定好
    // Beats 11.58%
    private static int countPairsMy1(int[] nums, int k) {
        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            } else {
                for (int index : map.get(num)) {
                    if ((index * i) % k == 0) {
                        result++;
                    }
                }
            }
            map.get(num).add(i);
        }
        return result;
    }

    // Beats 5.86%
    private static int countPairsMy2(int[] nums, int k) {
        int pairs = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // 先算出所有相等的组合
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        List<Integer> divisors = new ArrayList<>(); // 计算所有可以整除k的数字
        for (int d = 1; d * d <= k; d++) {
            if (k % d == 0) {
                divisors.add(d);
                if (d != k / d) {
                    divisors.add(k / d);
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Map<Integer, Integer> map2 = new HashMap<>();
            List<Integer> vec = entry.getValue();
            for (int i : vec) {
                int gcd = gcd(i, k);
                int need = k / gcd;
                pairs += map2.getOrDefault(need, 0);
                for (int d : divisors) {
                    if (i % d == 0) {
                        map2.put(d, map2.getOrDefault(d, 0) + 1);
                    }
                }
            }
        }
        return pairs;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Beats 98.65%
    private static int countPairsMy3(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {3, 1, 2, 2, 2, 1, 3},
                {1, 2, 3, 4},
                {10, 2, 3, 4, 9, 6, 3, 10, 3, 6, 3, 9, 1},
        };
        int[] kList = new int[]{
                2,
                1,
                4,
        };
        int[] resultList = new int[]{
                4,
                0,
                8,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countPairsMy1(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countPairs My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countPairsMy2(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countPairs My2 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countPairsMy3(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countPairs My3 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
