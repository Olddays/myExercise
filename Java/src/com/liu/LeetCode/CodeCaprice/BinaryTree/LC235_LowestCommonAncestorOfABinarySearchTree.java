package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC235_LowestCommonAncestorOfABinarySearchTree {
    // Beats 32.77%
    private static TreeNode lowestCommonAncestorMy1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val > q.val) { // 确保p小于q方便寻找
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        TreeNode left = null;
        if (root.val > p.val) {
            left = lowestCommonAncestorMy1(root.left, p, q);
        } else if (root.val == p.val) {
            return root;
        }
        TreeNode right = null;
        if (root.val < q.val) {
            right = lowestCommonAncestorMy1(root.right, p, q);
        } else if (root.val == q.val) {
            return root;
        }
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    // Beats 100.00%
    private static TreeNode lowestCommonAncestorMy2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        // 所以不用更换p和q，只要发现root在p和q中间，就可以返回root了
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorMy2(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorMy2(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        int[][] rootSet = new int[][]{
                {6, 2, 8, 0, 4, 7, 9, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 5},
                {6, 2, 8, 0, 4, 7, 9, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 5},
                {2, 1},
        };
        int[][] pSet = new int[][]{
                {2},
                {2},
                {2},
        };
        int[][] qSet = new int[][]{
                {8},
                {4},
                {1},
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

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            TreeNode p = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, pSet[i]);
            TreeNode q = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, qSet[i]);
            startTime = System.currentTimeMillis();
            result = lowestCommonAncestorMy2(root, p, q);
            endTime = System.currentTimeMillis();
            System.out.println("lowestCommonAncestor My2 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
