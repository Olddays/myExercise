package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD30_CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {
    public class TreeNode {
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

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode n, int[] a, int depth) {
        if (n == null || depth >= a.length || a[depth] != n.val) { // base cases.
            return false;
        }// key base case: a leave found.
        if (n.left == null && n.right == null) { // credit to @The_Legend_ for making the code clean
            return depth + 1 == a.length; // valid sequence?
        }
        return dfs(n.left, a, depth + 1) || dfs(n.right, a, depth + 1); // recurse to the children.
    }
}
