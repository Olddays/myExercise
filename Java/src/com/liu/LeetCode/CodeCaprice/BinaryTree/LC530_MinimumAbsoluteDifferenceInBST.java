package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC530_MinimumAbsoluteDifferenceInBST {

    private static TreeNode pre;

    private static int getMinimumDifferenceMy1(TreeNode root) {
        return getMinimumDifferenceMy1Helper(root);
    }

    private static int getMinimumDifferenceMy1Helper(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int result = Integer.MAX_VALUE;
        int left = getMinimumDifferenceMy1Helper(node.left);
        if (pre != null) {
            result = Math.min(left, node.val - pre.val);
        }
        pre = node;
        int right = getMinimumDifferenceMy1Helper(node.right);
        return Math.min(result, right);
    }

    public static void main(String[] args) {
        int[][] rootSet = new int[][]{
                {1, 0, 48, Integer.MIN_VALUE, Integer.MIN_VALUE, 12, 49},
                {4, 2, 6, 1, 3},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            pre = null;
            startTime = System.currentTimeMillis();
            result = getMinimumDifferenceMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("getMinimumDifference My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
