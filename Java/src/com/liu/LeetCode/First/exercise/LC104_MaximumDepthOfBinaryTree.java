package com.liu.LeetCode.First.exercise;

public class LC104_MaximumDepthOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        return depthCheck(root, 0);
    }

    private static int depthCheck(TreeNode node, int depth) {
        if (null != node) {
            return Math.max(depthCheck(node.left, depth + 1), depthCheck(node.right, depth + 1));
        }
        return depth;
    }
}
