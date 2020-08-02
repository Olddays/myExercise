package com.liu.LeetCode.ThirtyDays202006.exercise;

import com.liu.LeetCode.common.TreeNode;

/**
 * Created by Liu on 2020/6/23.
 */
public class TD23_CountCompleteTreeNodes {
    public static int countNodes(TreeNode root) {
        if (root != null) {
            return countNodes(root.left) + countNodes(root.right) + 1;
        } else {
            return 0;
        }
    }
}
