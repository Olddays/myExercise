package com.liu.LeetCode.First.exercise;

/**
 * Created by Liu on 2020/4/9.
 */
public class LC099_RecoverBinarySearchTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    static TreeNode left = null;
    static TreeNode right = null;
    static TreeNode previous = null;
    public static void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        recoverLoop(root);
        if (left != null && right != null) {
            int value = left.val;
            left.val = right.val;
            right.val = value;
        }
    }

    private static void recoverLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverLoop(root.left);
        if (previous != null) {
            if (previous.val > root.val) {
                if (left == null) {
                    left = previous;
                }
                right = root;
            }
        }
        previous = root;
        recoverLoop(root.right);
    }

}
