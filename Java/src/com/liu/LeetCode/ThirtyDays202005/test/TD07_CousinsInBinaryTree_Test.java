package com.liu.LeetCode.ThirtyDays202005.test;

import com.liu.LeetCode.common.bean.TreeNode;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD07_CousinsInBinaryTree.isCousins;

/**
 * Created by Liu on 2020/5/7.
 */
public class TD07_CousinsInBinaryTree_Test {

    public static void main(String[] args) {
        TreeNode root;
        int x;
        int y;
        boolean result;
        long startTime;
        long endTime;


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        x = 4;
        y = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(root, x, y);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CousinsInBinaryTree My 1 result " + result + " during time " + (endTime - startTime));


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        x = 5;
        y = 4;
        startTime = System.currentTimeMillis();
        result = testMy1(root, x, y);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CousinsInBinaryTree My 1 result " + result + " during time " + (endTime - startTime));


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        x = 2;
        y = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(root, x, y);
        endTime = System.currentTimeMillis();
        System.out.println("TD07_CousinsInBinaryTree My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(TreeNode root, int x, int y) {
        return isCousins(root, x, y);
    }
}
