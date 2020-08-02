package com.liu.LeetCode.ThirtyDays202006.exercise;

import com.liu.LeetCode.common.TreeNode;

/**
 * Created by Liu on 2020/6/1.
 */
public class TD01_InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        doInvert(root);
        return root;
    }

    private static void doInvert(TreeNode root) {
        if (root != null) {
            doInvert(root.left);
            doInvert(root.right);
            TreeNode cache = root.left;
            root.left = root.right;
            root.right = cache;
        }
    }
}
