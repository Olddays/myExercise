package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC104_MaximumDepthOfBinaryTree.TreeNode;

import static com.liu.LeetCode.First.exercise.LC104_MaximumDepthOfBinaryTree.maxDepth;

public class LC104_MaximumDepthOfBinaryTreeTest {
    public static void main(String[] args) {
        int result;
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(node);
        endTime = System.currentTimeMillis();
        System.out.println("MaximumDepthOfBinaryTree My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(TreeNode node) {
        return maxDepth(node);
    }

}
