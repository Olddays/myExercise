package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC538_ConvertBSTToGreaterTree {

    private static TreeNode preNode1 = null;
    private static int sum = 0;
    private static int preVal = 0;

    // Beats 100.00%
    private static TreeNode convertBSTMy1(TreeNode root) {
        if (root == null) {
            return null;
        }
        sum = countBSTValue(root);
        convertBSTMy1Helper(root);
        return root;
    }

    private static int countBSTValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countBSTValue(root.left);
        int right = countBSTValue(root.right);
        return left + right + root.val;
    }

    // 中序遍历
    private static void convertBSTMy1Helper(TreeNode node) {
        if (node == null) {
            return;
        }
        convertBSTMy1Helper(node.left);
        if (preNode1 != null) {
            sum -= preVal;
        }
        preNode1 = node;
        preVal = node.val;
        node.val = sum;
        convertBSTMy1Helper(node.right);
    }

    private static TreeNode preNode2 = null;

    // 逆中序遍历 右中左 这个方法更好 可以避免sum多遍历一次 也可以避免使用preVal去记录数据
    // Beats 100.00%
    private static TreeNode convertBSTMy2(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBSTMy2(root.right);
        if (preNode2 != null) {
            root.val += preNode2.val;
        }
        preNode2 = root;
        convertBSTMy2(root.left);
        return root;
    }

    public static void main(String[] args) {
        int[][] rootSet = {
                {4, 1, 6, 0, 2, 5, 7, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 8},
                {0, Integer.MIN_VALUE, 1},
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);

            preNode1 = null;
            sum = 0;
            preVal = 0;

            startTime = System.currentTimeMillis();
            result = convertBSTMy1(root);
            endTime = System.currentTimeMillis();
            System.out.println("convertBST My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);

            preNode2 = null;

            startTime = System.currentTimeMillis();
            result = convertBSTMy2(root);
            endTime = System.currentTimeMillis();
            System.out.println("convertBST My2 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
