package com.liu.LeetCode.ThirtyDays202006.test;


import com.liu.LeetCode.common.TreeNode;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD26_SumRootToLeafNumbers.sumNumbers;

/**
 * Created by Liu on 2020/6/27.
 */
public class TD26_SumRootToLeafNumbers_Test {

    public static void main(String[] args) {
        TreeNode root;
        int result;
        long startTime;
        long endTime;


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD26_SumRootToLeafNumbers My 1 result: " + result + ", during time " + (endTime - startTime));

        root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD26_SumRootToLeafNumbers My 1 result: " + result + ", during time " + (endTime - startTime));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD26_SumRootToLeafNumbers My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(TreeNode root) {
        return sumNumbers(root);
    }
}
