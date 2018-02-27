package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC040_CombinationSumII {
    /**
     * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     * <p>
     * Each number in C may only be used once in the combination.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * <p>
     * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
     * A solution set is:
     * <p>
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     */

    // 目前可以判断最后应该是一个深度优先的搜索,需要用到一个递归来进行处理
    public static List<List<Integer>> getCombinationSumIIMy1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain > 0) {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]); // 尝试加入下一个数字
                backtrack(list, tempList, nums, remain - nums[i], i + 1); // i + 1 because we can not reuse same elements
                tempList.remove(tempList.size() - 1); // 将尝试加入的数字删除进入下一个循环过程
            }
        } else if (remain == 0) {
            if (!list.contains(tempList)) { // 去重 通过contains判断去重会有相对比较高的时间复杂度
                list.add(new ArrayList<>(tempList));
            }
        } else {
            return;
        }
    }
}
