package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC450_DeleteNodeInABST {

    // Beats 100.00%
    private static TreeNode deleteNodeMy1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode left = root.left;
                TreeNode right = root.right;
                root = root.right;
                while (root.left != null) { // 找到右子树的最左节点，因为源root的left，一定是小于所有右子树节点的，所以要放在最左边
                    root = root.left;
                }
                root.left = left;
                return right;
            }
        }
        root.left = deleteNodeMy1(root.left, key);
        root.right = deleteNodeMy1(root.right, key);
        return root;
    }

    public static void main(String[] args) {
        int[][] rootSet = {
                {6, 3, 8, 2, 4, 7, 9},
                {5, 3, 6, 2, 4, Integer.MIN_VALUE, 7},
                {5, 3, 6, 2, 4, Integer.MIN_VALUE, 7},
                {5, 3, 6, 2, 4, Integer.MIN_VALUE, 7},
                {},
        };
        int[] keySet = {
                6,
                3,
                0,
                5,
                0,
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            startTime = System.currentTimeMillis();
            result = deleteNodeMy1(root, keySet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("deleteNode My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
