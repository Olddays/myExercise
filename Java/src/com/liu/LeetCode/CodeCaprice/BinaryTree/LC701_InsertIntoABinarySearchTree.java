package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC701_InsertIntoABinarySearchTree {

    // Beats 100.00%
    private static TreeNode insertIntoBSTMy1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insertIntoBSTMy1Helper(root, val);
        return root;
    }

    private static TreeNode insertIntoBSTMy1Helper(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        TreeNode newNode = null;
        if (val < node.val) {
            newNode = insertIntoBSTMy1Helper(node.left, val);
        } else if (val > node.val) {
            newNode = insertIntoBSTMy1Helper(node.right, val);
        }
        if (newNode != null) {
            if (val < node.val) {
                node.left = newNode;
            } else {
                node.right = newNode;
            }
        }
        return null;
    }

    // 简化 Beats 100.00%
    private static TreeNode insertIntoBSTMy2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBSTMy2(root.left, val);
        } else {
            root.right = insertIntoBSTMy2(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        int[][] rootSet = {
                {4, 2, 7, 1, 3},
                {40, 20, 60, 10, 30, 50, 70},
                {4, 2, 7, 1, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE},
        };
        int[] valSet = {
                5,
                25,
                5,
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            startTime = System.currentTimeMillis();
            result = insertIntoBSTMy1(root, valSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("insertIntoBST My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            startTime = System.currentTimeMillis();
            result = insertIntoBSTMy2(root, valSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("insertIntoBST My2 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
