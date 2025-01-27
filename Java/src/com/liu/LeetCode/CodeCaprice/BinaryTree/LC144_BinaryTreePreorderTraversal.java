package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144_BinaryTreePreorderTraversal {

    private static List<Integer> preorderTraversalMy1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalHelper(root, result);
        return result;
    }

    private static void preorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalHelper(root.left, result);
        preorderTraversalHelper(root.right, result);
    }

    private static List<Integer> preorderTraversalMy2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) { // 遍历和处理是同一个节点
            TreeNode node = nodeStack.pop();
            result.add(node.val); // 中
            if (node.right != null) { // 右
                nodeStack.push(node.right);
            }
            if (node.left != null) { // 左
                nodeStack.push(node.left);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, Integer.MIN_VALUE, 2, 3},
                {1, 2, 3, 4, 5, Integer.MIN_VALUE, 8, Integer.MIN_VALUE, Integer.MIN_VALUE, 6, 7, 9},
                {1},
        };
        List<Integer> result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = preorderTraversalMy1(node);
            endTime = System.currentTimeMillis();
            System.out.print("preorderTraversal My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = preorderTraversalMy2(node);
            endTime = System.currentTimeMillis();
            System.out.print("preorderTraversal My2 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
