package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC098_ValidateBinarySearchTree {

    // 中序遍历是否单调递增，如果是，那就是二叉搜索树，所以要用中序遍历
    // 二叉搜索树，节点要大于左子树的所有节点值，且小于右子树的所有节点值
    private static TreeNode preNode;

    private static boolean isValidBSTMy1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBSTMy1Helper(root);
    }

    private static boolean isValidBSTMy1Helper(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean left = isValidBSTMy1Helper(node.left);
        if (preNode != null && node.val <= preNode.val) {
            return false;
        }
        preNode = node;
        boolean right = isValidBSTMy1Helper(node.right);
        return left && right;
    }

    private static boolean isValidBSTMy2(TreeNode root) {
        return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    private static boolean validBST(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {2, 1, 3},
                {1, 1},
                {5, 4, 6, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 7},
                {5, 1, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 6},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, numsSet[i]);
            preNode = null;
            startTime = System.currentTimeMillis();
            result = isValidBSTMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("isValidBST My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, numsSet[i]);
            preNode = null;
            startTime = System.currentTimeMillis();
            result = isValidBSTMy2(node);
            endTime = System.currentTimeMillis();
            System.out.println("isValidBST My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
