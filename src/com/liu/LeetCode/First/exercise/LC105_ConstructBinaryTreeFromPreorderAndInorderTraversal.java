package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode getConstructBinaryTreeFromPreorderAndInorderTraversalMy1(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        return checkTreePath(preorder, inorder, 0, 0, length - 1);
    }

    private static TreeNode checkTreePath(int[] preorder, int[] inorder, int preRootId, int inStart, int inEnd) {
        int length = preorder.length;
        // 左
        if (preRootId + 1 > length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preRootId]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = checkTreePath(preorder, inorder, preRootId + 1, inStart, inIndex - 1);
        root.right = checkTreePath(preorder, inorder, preRootId + inIndex - inStart + 1, inIndex + 1, inEnd);
        return root;
    }

    // http://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal
    // The basic idea is here:
    // Say we have 2 arrays, PRE and IN.
    // Preorder traversing implies that PRE[0] is the root node.
    // Then we can find this PRE[0] in IN, say it's IN[5].
    // Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
    // Recursively doing this on subarrays, we can build a tree out of it.
    public static TreeNode getConstructBinaryTreeFromPreorderAndInorderTraversalAnswer1(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
