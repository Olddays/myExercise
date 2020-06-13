package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/1.
 */
public class TD01_InvertBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
