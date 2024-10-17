package com.liu.LeetCode.First.test;

import com.liu.LeetCode.common.bean.TreeNode;

import static com.liu.LeetCode.First.exercise.LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC106_ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    public static void main(String[] args) {
        int[] inorder = new int[]{
//                4, 2, 5, 1, 6, 3, 7
                1, 2, 3, 4
//                2, 1, 3
//                3, 2, 1
        };
        int[] postorder = new int[]{
//                4, 5, 2, 6, 7, 3, 1
                1, 4, 3, 2
//                2, 3, 1
//                3, 2, 1
        };
        long startTime;
        TreeNode result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(inorder, postorder);
        endTime = System.currentTimeMillis();
        System.out.println("ConstructBinaryTreeFromInorderAndPostorderTraversal My 1 result " + result.val + " during time " + (endTime - startTime));
        inOrderTraversal(result);
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy2(inorder, postorder);
        endTime = System.currentTimeMillis();
        System.out.println("ConstructBinaryTreeFromInorderAndPostorderTraversal My 2 result " + result.val + " during time " + (endTime - startTime));
        inOrderTraversal(result);
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy3(inorder, postorder);
        endTime = System.currentTimeMillis();
        System.out.println("ConstructBinaryTreeFromInorderAndPostorderTraversal My 3 result " + result.val + " during time " + (endTime - startTime));
        inOrderTraversal(result);
        System.out.println();
    }

    private static TreeNode testMy1(int[] preorder, int[] inorder) {
        return getConstructBinaryTreeFromInorderAndPostorderTraversalMy1(preorder, inorder);
    }

    private static TreeNode testMy2(int[] preorder, int[] inorder) {
        return getConstructBinaryTreeFromInorderAndPostorderTraversalMy2(preorder, inorder);
    }

    private static TreeNode testMy3(int[] preorder, int[] inorder) {
        return getConstructBinaryTreeFromInorderAndPostorderTraversalMy3(preorder, inorder);
    }

    private static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.val + " ");
            inOrderTraversal(node.right);
        }
    }
}
