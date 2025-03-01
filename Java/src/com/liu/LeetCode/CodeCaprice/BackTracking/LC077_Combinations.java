package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

// 减枝，都是可以做的，核心是去掉一些没必要遍历的情况，这个需要注意边界
public class LC077_Combinations {

    private static List<List<Integer>> combineMy1(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackMy1(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private static void backtrackMy1(List<List<Integer>> result, ArrayList<Integer> cache, int index, int n, int k) {
        if (cache.size() == k) {
            result.add(new ArrayList<>(cache));
            return;
        } else if (cache.size() + (n - index + 1) < k) {
            return; // 剪枝，元素不够了
        }
        for (int i = index; i <= n; i++) {
            cache.add(i);
            backtrackMy1(result, cache, i + 1, n, k);
            cache.remove(cache.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                4,
                4,
                1,
        };
        int[] kList = new int[]{
                4,
                2,
                1,
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = combineMy1(nList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("combine My1 result" + i + " ");
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
