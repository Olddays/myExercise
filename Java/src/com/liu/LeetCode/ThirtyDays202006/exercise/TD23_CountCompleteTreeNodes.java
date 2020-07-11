package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/23.
 */
public class TD23_CountCompleteTreeNodes {
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

    public static int countNodes(TreeNode root) {
        if (root != null) {
            return countNodes(root.left) + countNodes(root.right) + 1;
        } else {
            return 0;
        }
    }
}
