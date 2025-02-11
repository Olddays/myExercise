package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC700_SearchInABinarySearchTree {

    private static TreeNode searchBSTMy1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBSTMy1(root.left, val);
        } else {
            return searchBSTMy1(root.right, val);
        }
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {4, 2, 7, 1, 3},
                {4, 2, 7, 1, 3},
        };
        int[] valSet = new int[]{
                2,
                5,
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, numsSet[i]);
            startTime = System.currentTimeMillis();
            result = searchBSTMy1(node, valSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("searchBST My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
