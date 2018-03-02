package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2017/9/30.
 */
public class LC216_CombinationSumIII {
    /**
     * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     * <p>
     * Example 1:
     * <p>
     * Input: k = 3, n = 7
     * <p>
     * Output:
     * <p>
     * [[1,2,4]]
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: k = 3, n = 9
     * <p>
     * Output:
     * <p>
     * [[1,2,6], [1,3,5], [2,3,4]]
     */

    public static List<List<Integer>> getCombinationSumIIIMy1(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtraceMy1(result, new ArrayList<>(), k, 1, n);
        return result;
    }

    private static void backtraceMy1(List<List<Integer>> result, List<Integer> cache, int size, int start, int total) {
        if (cache.size() == size && total == 0) {
            result.add(new ArrayList<>(cache));
            return;
        }
        for (int i = start; i < 10; i++) {
            cache.add(i);
            if (cache.size() > 0 && result.contains(cache)) {
                // 先add上目前要加入的数字,再判断是否存在,如果已经存在,则删除当前数字并continue
                cache.remove(cache.size() - 1);
                continue;
            }
            backtraceMy1(result, cache, size, i + 1, total - i);
            cache.remove(cache.size() - 1);
        }
    }
}
