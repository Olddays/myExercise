package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC094_BinaryTreeInorderTraversal {
    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * <p>
     * For example:
     * Given binary tree [1,null,2,3],
     * <p>
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * return [1,3,2].
     * <p>
     * Note: Recursive solution is trivial, could you do it iteratively?
     */

    /**
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

        public TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> getBinaryTreeInorderTraversalMy1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        getInorderTraversalMy1(result, root);
        return result;
    }

    private static void getInorderTraversalMy1(List<Integer> result, TreeNode root) {
        if (root.left != null) {
            getInorderTraversalMy1(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            getInorderTraversalMy1(result, root.right);
        }
    }
}
