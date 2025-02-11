package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;

public class LC099_RecoverBinarySearchTree {

    // 左中右的中序遍历的话，应该是升序的，可以先通过中序寻找到错误的点位，再更换
    // 要记录的内容包括，要换的节点，节点的父（左或右）、节点的子（左和右）
    // 不用这么麻烦，换val值就行
    private static TreeNode prev;

    private static void recoverTreeMy1(TreeNode root) {
        TreeNode[] preChangePair = new TreeNode[2];

        inorderTraversalMy1(root, preChangePair);
        int temp = preChangePair[0].val;
        preChangePair[0].val = preChangePair[1].val;
        preChangePair[1].val = temp;
    }

    private static void inorderTraversalMy1(TreeNode root, TreeNode[] preChangePair) {
        if (root == null) {
            return;
        }
        inorderTraversalMy1(root.left, preChangePair);
        if (prev != null && prev.val > root.val) {
            if (preChangePair[0] == null) {
                preChangePair[0] = prev;
            }
            preChangePair[1] = root;
        }
        prev = root;
        inorderTraversalMy1(root.right, preChangePair);
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, 2},
                {3, 1, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 2},
        };
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            recoverTreeMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("recoverTree My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, node)
                    + " during time " + (endTime - startTime));
        }
    }
}
