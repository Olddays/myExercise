package com.liu.LeetCode.ThirtyDays202005.exercise;

import com.liu.LeetCode.common.TreeNode;

/**
 * Created by Liu on 2020/5/28.
 */
public class TD24_ConstructBinarySearchTreeFromPreorderTraversal {

    public static TreeNode bstFromPreorder(int[] preorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            insertNodeInTree(root, node);
        }
        return root;
    }

    private static void insertNodeInTree(TreeNode root, TreeNode node) {
        if (node == null) {
            return;
        }
        if (root.val > node.val) {
            if (root.left != null) {
                insertNodeInTree(root.left, node);
            } else {
                root.left = node;
            }
        }
        if (root.val < node.val) {
            if (root.right != null) {
                insertNodeInTree(root.right, node);
            } else {
                root.right = node;
            }
        }
    }
}
