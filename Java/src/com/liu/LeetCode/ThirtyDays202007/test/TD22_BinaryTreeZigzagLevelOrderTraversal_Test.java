package com.liu.LeetCode.ThirtyDays202007.test;

import com.liu.LeetCode.common.bean.TreeNode;

import java.util.List;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD22_BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder;

/**
 * Created by Liu on 2020/7/22.
 */
public class TD22_BinaryTreeZigzagLevelOrderTraversal_Test {
    public static void main(String[] args) {
        TreeNode root;
        List<List<Integer>> result;
        long startTime;
        long endTime;

        root = new TreeNode(1);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_BinaryTreeZigzagLevelOrderTraversal My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_BinaryTreeZigzagLevelOrderTraversal My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_BinaryTreeZigzagLevelOrderTraversal My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD22_BinaryTreeZigzagLevelOrderTraversal My 1 result " + result + " during time " + (endTime - startTime));

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
        System.out.println("TD22_BinaryTreeZigzagLevelOrderTraversal My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static List<List<Integer>> testMy1(TreeNode root) {
        return zigzagLevelOrder(root);
    }
}
