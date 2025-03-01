package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC669_TrimABinarySearchTree {

    // Beats 100.00%
    private static TreeNode trimBSTMy1(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) { // 此时右子树大于root.val，所以要继续遍历，核心是越过root，并且剪除左子树
            return trimBSTMy1(root.right, low, high);
        } else if (root.val > high) { // 此时左子树小于root.val，所以要继续遍历，核心是越过root，并且剪除右子树
            return trimBSTMy1(root.left, low, high);
        }
        root.left = trimBSTMy1(root.left, low, high);
        root.right = trimBSTMy1(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        int[][] rootSet = {
                {1, 0, 2},
                {3, 0, 4, Integer.MIN_VALUE, 2, Integer.MIN_VALUE, Integer.MIN_VALUE, 1},
        };
        int[] lowSet = {
                1,
                1,
        };
        int[] highSet = {
                2,
                3,
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            startTime = System.currentTimeMillis();
            result = trimBSTMy1(root, lowSet[i], highSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("trimBST My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
