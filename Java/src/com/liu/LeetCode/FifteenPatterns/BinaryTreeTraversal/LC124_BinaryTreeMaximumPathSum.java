package com.liu.LeetCode.FifteenPatterns.BinaryTreeTraversal;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Traversal involves visiting all the nodes in a binary tree in a specific order.
 * PreOrder: root -> left -> right
 * InOrder: left -> root -> right
 * PostOrder: left -> right -> root
 * Sample Problem:
 * Problem Statement: Perform inorder traversal of a binary tree.
 * Example:
 * Input: root = [1, null, 2, 3]
 * Output: [1, 3, 2]
 * Explanation:
 * Inorder traversal visits nodes in the order: left, root, right.
 * Use recursion or a stack to traverse the tree in this order.
 */
public class LC124_BinaryTreeMaximumPathSum {
    // error
    private static int maxPathSumMy1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[]{Integer.MIN_VALUE};
        postOrderSearch(root, result, new ArrayList<>());
        return result[0];
    }

    private static void postOrderSearch(TreeNode root, int[] result, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrderSearch(root.left, result, list);
        postOrderSearch(root.right, result, list);
        list.add(root.val);
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }
            result[0] = Math.max(sum, result[0]);
        }
    }

    private static int maxPathSumAnswer1(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        postOrderSearchSum(root, result); // Call helper function to recursively calculate maximum path sum
        return result[0];
    }

    private static int postOrderSearchSum(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        // Calculate maximum path sum for the left and right subtrees
        int leftSum = Math.max(0, postOrderSearchSum(root.left, result)); // max path sum starting from left child
        int rightSum = Math.max(0, postOrderSearchSum(root.right, result)); // max path sum starting from right child
        // 题目提到，可以不经过特定的点，不是必须使用子树，比如{2,-1}就可以只要2
        // 这里比较0和子树的和是因为子树的和可能为负数，那么就不要加了，因为加上了负数，那么子树的和就会变小，所以要比较0和子树的和

        // Update the global maxSum by considering the path through the current node
        result[0] = Math.max(result[0], leftSum + rightSum + root.val);

        // Return the maximum path sum starting from the current node (either left or right subtree + current node value)
        return Math.max(leftSum, rightSum) + root.val;
    }

    public static void main(String[] args) {
        int[][] rootNodeSet = new int[][]{
                {2, -1},
                {-10, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7},
                {1, 2, 3},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxPathSumMy1((TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_PREORDER_BINARY_TREE_ROOT, rootNodeSet[i]));
            endTime = System.currentTimeMillis();
            System.out.println("maxPathSum My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < rootNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxPathSumAnswer1((TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_PREORDER_BINARY_TREE_ROOT, rootNodeSet[i]));
            endTime = System.currentTimeMillis();
            System.out.println("maxPathSum Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
