package com.liu.LeetCode.ThirtyDays202007.exercise;

import com.liu.LeetCode.common.TreeNode;

/**
 * Created by Liu on 2020/7/13.
 */
public class TD13_SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
