package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC040_CombinationSumII {

    private static List<List<Integer>> combinationSum2My1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackMy1(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrackMy1(List<List<Integer>> result, ArrayList<Integer> cache, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(cache));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) { // 连续两个相同数字时，跟i-1比较，可以跳过当前的情况，比如case的1,2,5和1,7在第一个1已经计算了，所以跳过第二个1
                continue;
            }
            cache.add(candidate);
            backtrackMy1(result, cache, candidates, target - candidate, i + 1);
            cache.remove(cache.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] candidatesList = new int[][]{
                {10, 1, 2, 7, 6, 1, 5},
                {2, 5, 2, 1, 2},
        };
        int[] targetList = new int[]{
                8,
                5,
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < candidatesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = combinationSum2My1(candidatesList[i], targetList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("combination2Sum My1 result" + i + " ");
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
