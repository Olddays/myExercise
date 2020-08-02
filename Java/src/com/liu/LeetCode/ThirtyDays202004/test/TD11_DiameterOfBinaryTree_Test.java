package com.liu.LeetCode.ThirtyDays202004.test;


import com.liu.LeetCode.common.TreeNode;

import static com.liu.LeetCode.ThirtyDays202004.exercise.TD11_DiameterOfBinaryTree.diameterOfBinaryTreeMy1;
import static com.liu.LeetCode.ThirtyDays202004.exercise.TD11_DiameterOfBinaryTree.diameterOfBinaryTreeMy2;


public class TD11_DiameterOfBinaryTree_Test {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        TreeNode[] inputs = {
                root1, root2
        };

        long startTime;
        int result;
        long endTime;

        for (TreeNode root : inputs) {
            startTime = System.currentTimeMillis();
            result = testMy1(root);
            endTime = System.currentTimeMillis();
            System.out.println("DiameterOfBinaryTree Answer 1 result: " + result + ", during time " + (endTime - startTime));
        }

        for (TreeNode root : inputs) {
            startTime = System.currentTimeMillis();
            result = testMy2(root);
            endTime = System.currentTimeMillis();
            System.out.println("DiameterOfBinaryTree Answer 1 result: " + result + ", during time " + (endTime - startTime));
        }
    }

    private static int testMy1(TreeNode root) {
        return diameterOfBinaryTreeMy1(root);
    }

    private static int testMy2(TreeNode root) {
        return diameterOfBinaryTreeMy2(root);
    }
}
