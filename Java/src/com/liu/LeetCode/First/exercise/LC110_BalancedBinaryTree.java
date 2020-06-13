package com.liu.LeetCode.First.exercise;

/**
 * Created by Liu on 2020/6/9.
 */
public class LC110_BalancedBinaryTree {
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

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    private static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.left != null) {
            left = getDepth(root.left);
        }
        int right = 0;
        if (root.right != null) {
            right = getDepth(root.right);
        }
        return Math.max(left, right) + 1;
    }
}
