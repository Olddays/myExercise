package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC118_PascalsTriangle {
    /**
     * Given numRows, generate the first numRows of Pascal's triangle.
     * <p>
     * For example, given numRows = 8,
     * Return
     * <p>
     * [
     * [1],
     * [1, 1],
     * [1, 2, 1],
     * [1, 3, 3, 1],
     * [1, 4, 6, 4, 1]
     * [1, 5, 10, 10, 5, 1]
     * [1, 6, 15, 20, 15, 6, 1]
     * [1, 7, 21, 35, 35, 21, 7, 1]
     * [1, 8, 28, 56, 70, 56, 28, 8, 1]
     * ]
     */

    // 哇哦,菲波那切数列
    public static List<List<Integer>> getPascalsTriangleMy1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        getPascalsTriangleListMy1(result, 0, numRows);
        return result;
    }

    public static void getPascalsTriangleListMy1(List<List<Integer>> result, int start, int end) {
        if (start >= end) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        if (start == 0) {
            list.add(1);
            result.add(list);
        } else if (start == 1) {
            list.add(1);
            list.add(1);
            result.add(list);
        } else {
            list.add(1);
            List<Integer> cache = result.get(result.size() - 1);
            for (int i = 0; i < cache.size() - 1; i++) {
                list.add(cache.get(i) + cache.get(i + 1));
            }
            list.add(1);
            result.add(list);
        }
        start++;
        getPascalsTriangleListMy1(result, start, end);
    }
}
