package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

// 左右子树高度差小于等于1
public class LC110_BalancedBinaryTree {

    // 后序遍历，因为需要计算左右深度
    private static boolean isBalancedMy1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = maxDepthMy1(root.left);
        int rightDepth = maxDepthMy1(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalancedMy1(root.left) && isBalancedMy1(root.right);
    }

    private static int maxDepthMy1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepthMy1(root.left);
        int right = maxDepthMy1(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7},
                {1, 2, 2, 3, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, 4, 4},
                {}
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = isBalancedMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("isBalanced My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
