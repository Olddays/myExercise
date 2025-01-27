package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC094_BinaryTreeInorderTraversal {

    private static List<Integer> inorderTraversalMy1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private static void inorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }

    private static List<Integer> inorderTraversalMy2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode current = root;
        nodeStack.push(current);
        while (current != null && !nodeStack.isEmpty()) {
            if (current.left != null) { // 处理左
                nodeStack.push(current.left);
                current = current.left;
            } else {
                current = nodeStack.pop();
                result.add(current.val); // 中
                if (current.right != null) { // 当没有左时，如果有右，则处理右
                    nodeStack.push(current.right);
                    current = current.right;
                } else { // 当没有左时，也没有右，则退回上一层并处理右
                    current = nodeStack.isEmpty() ? null : nodeStack.pop();
                    if (current != null) {
                        result.add(current.val); // 中
                        if (current.right != null) {
                            nodeStack.push(current.right);
                            current = current.right;
                        }
                    }
                }
            }
        }
        return result;
    }

    private static List<Integer> inorderTraversalMy3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>(); // 记录指针访问过的元素
        TreeNode current = root;
        while (current != null || !nodeStack.isEmpty()) {
            if (current != null) {
                nodeStack.push(current);
                current = current.left; // 先向左
            } else {
                current = nodeStack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2, 3, 4, 5, Integer.MIN_VALUE, 8, Integer.MIN_VALUE, Integer.MIN_VALUE, 6, 7, 9},
                {1, Integer.MIN_VALUE, 2, 3},
                {1},
        };
        List<Integer> result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = inorderTraversalMy1(node);
            endTime = System.currentTimeMillis();
            System.out.print("inorderTraversal My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = inorderTraversalMy2(node);
            endTime = System.currentTimeMillis();
            System.out.print("inorderTraversal My2 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = inorderTraversalMy3(node);
            endTime = System.currentTimeMillis();
            System.out.print("inorderTraversal My3 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
