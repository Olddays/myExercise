package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC216_CombinationSumIII {

    private static List<List<Integer>> combinationSum3My1(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) { // 减枝
            return result;
        }
        backtrackMy1(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private static void backtrackMy1(List<List<Integer>> result, ArrayList<Integer> cache, int k, int n, int now) {
        if (cache.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(cache));
            }
        } else if (n < 0 || cache.size() > k) { // 减枝
            return;
        }
        for (int i = now; i <= 9; i++) {
            cache.add(i);
            backtrackMy1(result, cache, k, n - i, i + 1);
            cache.remove(cache.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] kList = new int[]{
                3,
                3,
                4,
        };
        int[] nList = new int[]{
                7,
                9,
                1,
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = combinationSum3My1(kList[i], nList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("combinationSum3 My1 result" + i + " ");
            for (List<Integer> list : result) {
                for (int val : list) {
                    System.out.print(val + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
