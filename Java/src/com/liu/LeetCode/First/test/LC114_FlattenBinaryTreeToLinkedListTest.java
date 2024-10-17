package com.liu.LeetCode.First.test;

import com.liu.LeetCode.common.bean.TreeNode;

import static com.liu.LeetCode.First.exercise.LC114_FlattenBinaryTreeToLinkedList.flatten;

/**
 * Created by Liu on 2020/7/14.
 */
public class LC114_FlattenBinaryTreeToLinkedListTest {
    public static void main(String[] args) {
        TreeNode root;
        long startTime;
        long endTime;


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        startTime = System.currentTimeMillis();
        testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_FlattenAMultilevelDoublyLinkedList My 1 during time " + (endTime - startTime));
        inOrderScan(root);
        System.out.println();
    }

    private static void inOrderScan(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            inOrderScan(root.left);
            inOrderScan(root.right);
        }
    }

    private static void testMy1(TreeNode root) {
        flatten(root);
    }
}
