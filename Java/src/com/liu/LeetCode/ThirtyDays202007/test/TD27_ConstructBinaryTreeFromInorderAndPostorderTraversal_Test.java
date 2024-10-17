package com.liu.LeetCode.ThirtyDays202007.test;

import com.liu.LeetCode.common.bean.TreeNode;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD27_ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree;

/**
 * Created by Liu on 2020/7/27.
 */
public class TD27_ConstructBinaryTreeFromInorderAndPostorderTraversal_Test {

    public static void main(String[] args) {
        int[] inorder;
        int[] postorder;
        TreeNode result;
        long startTime;
        long endTime;


        inorder = new int[]{
                9, 3, 15, 20, 7
        };
        postorder = new int[]{
                9, 15, 7, 20, 3
        };
        startTime = System.currentTimeMillis();
        result = testMy1(inorder, postorder);
        endTime = System.currentTimeMillis();
        System.out.println("TD27_ConstructBinaryTreeFromInorderAndPostorderTraversal My 1, during time " + (endTime - startTime));
        preOrderPrint(result);
        System.out.println();
    }

    private static void preOrderPrint(TreeNode result) {
        if (result != null) {
            preOrderPrint(result.left);
            System.out.print(result.val + " ");
            preOrderPrint(result.right);
        }
    }

    private static TreeNode testMy1(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder);
    }
}
