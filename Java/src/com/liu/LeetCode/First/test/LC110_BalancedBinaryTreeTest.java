package com.liu.LeetCode.First.test;

import com.liu.LeetCode.common.TreeNode;

import static com.liu.LeetCode.First.exercise.LC110_BalancedBinaryTree.isBalanced;

/**
 * Created by Liu on 2020/6/9.
 */
public class LC110_BalancedBinaryTreeTest {

    public static void main(String[] args) {
        TreeNode root;
        boolean result;
        long startTime;
        long endTime;

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("BalancedBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("BalancedBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.left = new TreeNode(4);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("BalancedBinaryTree My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(TreeNode root) {
        return isBalanced(root);
    }

}
