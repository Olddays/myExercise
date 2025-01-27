package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

// 从下到上依次处理
public class LC111_MinimumDepthOfBinaryTree {

    // beats 9.84%
    // 后序遍历
    private static int minDepthMy1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepthMy1(root.left); // 左
        int right = minDepthMy1(root.right); // 右
        if (left == 0 || right == 0) { // 中
            // 避免出现单边树的情况
            return left + right + 1;
        }
        return 1 + Math.min(left, right);
    }

    // Beats 44.75%
    private static int minDepthAnswer1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepthAnswer1(root.left);
        int right = minDepthAnswer1(root.right);
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + right;
        }
        if (root.right == null) {
            return 1 + left;
        }
        return 1 + Math.min(left, right);
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7},
                {2, Integer.MIN_VALUE, 3, Integer.MIN_VALUE, 4, Integer.MIN_VALUE, 5, Integer.MIN_VALUE, 6},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = minDepthMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("maxDepth My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = minDepthAnswer1(node);
            endTime = System.currentTimeMillis();
            System.out.println("maxDepth Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
