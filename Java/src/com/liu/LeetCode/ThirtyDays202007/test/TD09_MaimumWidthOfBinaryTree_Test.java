package com.liu.LeetCode.ThirtyDays202007.test;

import com.liu.LeetCode.ThirtyDays202007.exercise.TD09_MaimumWidthOfBinaryTree.TreeNode;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD09_MaimumWidthOfBinaryTree.widthOfBinaryTreeMy1;

/**
 * Created by Liu on 2020/7/10.
 */
public class TD09_MaimumWidthOfBinaryTree_Test {
    public static void main(String[] args) {
        TreeNode root;
        int result;
        long startTime;
        long endTime;

        root = new TreeNode(1);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_MaimumWidthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_MaimumWidthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_MaimumWidthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_MaimumWidthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD09_MaimumWidthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static int testMy1(TreeNode root) {
        return widthOfBinaryTreeMy1(root);
    }

}
