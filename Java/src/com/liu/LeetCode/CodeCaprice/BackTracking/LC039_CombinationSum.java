package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC039_CombinationSum {

    // Beats 83.11%
    private static List<List<Integer>> combinationSumMy1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackMy1(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    // 加入index，就可以避免重复，因为随着index的增加等于每个数字作为开头第一个数字的情况只会出现一次
    private static void backtrackMy1(List<List<Integer>> result, ArrayList<Integer> cache, int[] candidates, int target, int index) {
        if (target == 0) {
//            if (!result.contains(cache)) { 如果多了这个判断，就会从Beats 83.11% 降低到 24.49%
            result.add(new ArrayList<>(cache));
//            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target - candidate >= 0) {
                cache.add(candidate);
                backtrackMy1(result, cache, candidates, target - candidate, i);
                cache.remove(cache.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] candidatesList = new int[][]{
                {2, 3, 6, 7},
                {2, 3, 5},
                {2},
        };
        int[] targetList = new int[]{
                7,
                8,
                1,
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < candidatesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = combinationSumMy1(candidatesList[i], targetList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("combinationSum My1 result" + i + " ");
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
