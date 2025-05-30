package com.liu.LeetCode.ThirtyDays202005.exercise;

import com.liu.LeetCode.common.bean.TreeNode;

/**
 * Created by Liu on 2020/5/7.
 */
public class TD07_CousinsInBinaryTree {
    public static boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xParent = getDepth(root, x, 0);
        TreeNode yParent = getDepth(root, y, 0);
        return xParent != null && yParent != null && xParent != yParent && xParent.val == yParent.val;
    }

    private static TreeNode getDepth(TreeNode root, int num, int depth) {
        if (root != null) {
            if (root.left != null && root.left.val == num || root.right != null && root.right.val == num) {
                root.val = depth;
                return root;
            }
            TreeNode left = getDepth(root.left, num, depth + 1);
            if (left != null) {
                return left;
            }
            TreeNode right = getDepth(root.right, num, depth + 1);
            if (right != null) {
                return right;
            }
        }
        return null;
    }
}
