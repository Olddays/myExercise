package com.liu.LeetCode.ThirtyDays202006.test;

import com.liu.LeetCode.common.TreeNode;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD15_SearchInABinarySearchTree.searchBST;

/**
 * Created by Liu on 2020/6/15.
 */
public class TD15_SearchInABinarySearchTree_Test {
    public static void main(String[] args) {
        TreeNode root;
        int val;
        TreeNode result;
        long startTime;
        long endTime;


        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(2);
        val = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(root, val);
        endTime = System.currentTimeMillis();
        System.out.println("TD15_SearchInABinarySearchTree My 1 during time " + (endTime - startTime));
        inorder(result);
    }

    private static void inorder(TreeNode result) {
        if (result != null) {
            inorder(result.left);
            System.out.print(result.val + " ");
            inorder(result.right);
        }
    }

    private static TreeNode testMy1(TreeNode root, int val) {
        return searchBST(root, val);
    }
}
