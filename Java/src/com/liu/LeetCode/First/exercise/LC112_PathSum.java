package com.liu.LeetCode.First.exercise;

/**
 * Created by Liu on 2020/6/12.
 */
public class LC112_PathSum {
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

    public static boolean hasPathSum(TreeNode root, int sum) {
        return deepFirstScan(root, sum, 0);
    }

    private static boolean deepFirstScan(TreeNode root, int sum, int cache) {
        return root != null && (deepFirstScan(root.left, sum, cache + root.val)
                || deepFirstScan(root.right, sum, cache + root.val)
                || sum == cache + root.val && root.left == null && root.right == null);
    }
}
