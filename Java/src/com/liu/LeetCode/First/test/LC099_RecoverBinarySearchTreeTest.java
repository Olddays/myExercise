package com.liu.LeetCode.First.test;


import com.liu.LeetCode.common.TreeNode;

import static com.liu.LeetCode.First.exercise.LC099_RecoverBinarySearchTree.recoverTree;

/**
 * Created by Liu on 2020/4/9.
 */
public class LC099_RecoverBinarySearchTreeTest {

    public static void main(String[] args) {
        char[] nums = new char[]{
                '1', '3', ' ', ' ', '2'
        };
        TreeNode root = new TreeNode(nums[0] - '0');
        TreeNode node = root;
        boolean isLeft = false;
        for (int i = 1; i < nums.length; i++) {
            isLeft = !isLeft;
            char c = nums[i];
            if (c == ' ') {
                continue;
            }
            if (isLeft) {
                node.left = new TreeNode(c - '0');
            } else {
                node.right = new TreeNode(c - '0');
                if (node.left != null) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("BinaryTreeInorderTraversal My 1, during time " + (endTime - startTime));
        inOrderTraversal(root);
    }

    private static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        } else {
            inOrderTraversal(node.left);
            System.out.println(node.val + " ");
            inOrderTraversal(node.right);
        }
    }

    private static void testMy1(TreeNode root) {
        recoverTree(root);
    }
}
