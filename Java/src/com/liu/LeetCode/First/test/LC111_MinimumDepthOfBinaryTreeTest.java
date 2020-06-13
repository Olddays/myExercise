package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC111_MinimumDepthOfBinaryTree.TreeNode;

import static com.liu.LeetCode.First.exercise.LC111_MinimumDepthOfBinaryTree.minDepth;

/**
 * Created by Liu on 2020/6/10.
 */
public class LC111_MinimumDepthOfBinaryTreeTest {

    public static void main(String[] args) {
        TreeNode root;
        int result;
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
        System.out.println("MinimumDepthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

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
        System.out.println("MinimumDepthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

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
        System.out.println("MinimumDepthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(TreeNode root) {
        return minDepth(root);
    }

}
