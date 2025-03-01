package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC236_LowestCommonAncestorOfABinaryTree {

    // 最近公共祖先，那么应该用后续，左右中，或者用层序
    private static TreeNode lowestCommonAncestorMy1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestorMy1(root.left, p, q);
        TreeNode right = lowestCommonAncestorMy1(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        int[][] rootSet = new int[][]{
                {3, 5, 1, 6, 2, 0, 8, Integer.MIN_VALUE, Integer.MIN_VALUE, 7, 4},
                {3, 5, 1, 6, 2, 0, 8, Integer.MIN_VALUE, Integer.MIN_VALUE, 7, 4},
                {1, 2},
        };
        int[][] pSet = new int[][]{
                {5},
                {5},
                {1},
        };
        int[][] qSet = new int[][]{
                {4},
                {1},
                {2},
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            TreeNode p = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, pSet[i]);
            TreeNode q = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, qSet[i]);
            startTime = System.currentTimeMillis();
            result = lowestCommonAncestorMy1(root, p, q);
            endTime = System.currentTimeMillis();
            System.out.println("lowestCommonAncestor My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
