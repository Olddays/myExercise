package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC105_ConstructBinaryTreeFromPreorderAndInorderTraversal.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC105_ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    public static void main(String[] args) {
        int[] preorder = new int[]{
                1, 2, 4, 5, 3, 6, 7
//                1, 2, 3
//                1, 2, 3
        };
        int[] inorder = new int[]{
                4, 2, 5, 1, 6, 3, 7
//                2, 1, 3
//                3, 2, 1
        };
        long startTime;
        TreeNode result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(preorder, inorder);
        endTime = System.currentTimeMillis();
        System.out.println("ConstructBinaryTreeFromPreorderAndInorderTraversal My 1 result " + result.val + " during time " + (endTime - startTime));
        inOrderTraversal(result);
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(preorder, inorder);
        endTime = System.currentTimeMillis();
        System.out.println("ConstructBinaryTreeFromPreorderAndInorderTraversal Answer 1 result " + result.val + " during time " + (endTime - startTime));
        inOrderTraversal(result);
        System.out.println();
    }

    private static TreeNode testMy1(int[] preorder, int[] inorder) {
        return getConstructBinaryTreeFromPreorderAndInorderTraversalMy1(preorder, inorder);
    }

    private static TreeNode testAnswer1(int[] preorder, int[] inorder) {
        return getConstructBinaryTreeFromPreorderAndInorderTraversalAnswer1(preorder, inorder);
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
}
