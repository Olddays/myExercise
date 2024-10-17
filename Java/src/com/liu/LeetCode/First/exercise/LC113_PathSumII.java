package com.liu.LeetCode.First.exercise;

import com.liu.LeetCode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/6/23.
 */
public class LC113_PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();
        depthFirstScan(result, sum, cache, root, 0);
        return result;
    }

    private static void depthFirstScan(List<List<Integer>> result, int sum, List<Integer> cache, TreeNode root, int nowCount) {
        if (root == null) {
            return;
        }
        int val = root.val;
        nowCount += val;
        cache.add(val);
        if (nowCount == sum && root.left == null && root.right == null) {
            List<Integer> saver = new ArrayList<>(cache);
            result.add(saver);
        } else {
            depthFirstScan(result, sum, cache, root.left, nowCount);
            depthFirstScan(result, sum, cache, root.right, nowCount);
        }
        cache.remove(cache.size() - 1);
    }
}
