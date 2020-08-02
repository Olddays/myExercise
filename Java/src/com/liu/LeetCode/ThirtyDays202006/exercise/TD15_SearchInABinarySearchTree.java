package com.liu.LeetCode.ThirtyDays202006.exercise;

import com.liu.LeetCode.common.TreeNode;

/**
 * Created by Liu on 2020/6/15.
 */
public class TD15_SearchInABinarySearchTree {

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
