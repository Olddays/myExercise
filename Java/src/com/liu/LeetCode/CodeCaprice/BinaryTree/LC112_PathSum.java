package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC112_PathSum {
    private static boolean hasPathSumMy1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        boolean left = hasPathSumMy1(root.left, targetSum - root.val);
        if (left) {
            return true;
        }
        boolean right = hasPathSumMy1(root.right, targetSum - root.val);
        if (right) {
            return true;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 1},
                {1, 2, 3},
                {},
        };
        int[] targetSumSet = new int[]{
                22,
                5,
                0,
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = hasPathSumMy1(node, targetSumSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("hasPathSum My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
