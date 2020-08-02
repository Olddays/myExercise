package com.liu.LeetCode.First.exercise;

import com.liu.LeetCode.common.TreeNode;

/**
 * Created by Liu on 2020/6/12.
 */
public class LC112_PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {
        return deepFirstScan(root, sum, 0);
    }

    private static boolean deepFirstScan(TreeNode root, int sum, int cache) {
        return root != null && (deepFirstScan(root.left, sum, cache + root.val)
                || deepFirstScan(root.right, sum, cache + root.val)
                || sum == cache + root.val && root.left == null && root.right == null);
    }
}
