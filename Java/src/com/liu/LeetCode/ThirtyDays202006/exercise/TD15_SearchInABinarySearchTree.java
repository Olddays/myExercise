package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/15.
 */
public class TD15_SearchInABinarySearchTree {
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

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) {
                return root;
            } else {
                TreeNode leftNode = searchBST(root.left, val);
                if (leftNode != null) {
                    return leftNode;
                }
                TreeNode rightNode = searchBST(root.right, val);
                if (rightNode != null) {
                    return rightNode;
                }
            }
        }
        return null;
    }
}
