package com.liu.LeetCode.ThirtyDays202006.test;

import com.liu.LeetCode.ThirtyDays202006.exercise.TD01_InvertBinaryTree.TreeNode;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD01_InvertBinaryTree.invertTree;

/**
 * Created by Liu on 2020/6/1.
 */
public class TD01_InvertBinaryTree_Test {
    public static void main(String[] args) {
        TreeNode root;
        TreeNode result;
        long startTime;
        long endTime;

        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD01_InvertBinaryTree My 1 result " + result + " during time " + (endTime - startTime));
        inOrderTraversal(result);
        System.out.println();

    }

    private static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.val + " ");
            inOrderTraversal(node.right);
        }
    }

    private static TreeNode testMy1(TreeNode root) {
        return invertTree(root);
    }

}
