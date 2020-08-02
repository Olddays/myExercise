package com.liu.LeetCode.First.exercise;

import com.liu.LeetCode.common.TreeNode;

/**
 * Created by Liu on 2020/7/14.
 */
public class LC114_FlattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                TreeNode cache = root.right;
                TreeNode left = root.left;
                root.right = left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = cache;
                root.left = null;
            }
            flatten(root.right);
        }
    }
}
