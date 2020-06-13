package com.liu.LeetCode.ThirtyDays202005.test;

import com.liu.LeetCode.ThirtyDays202005.exercise.TD20_KthSmallestElementInABST.TreeNode;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD20_KthSmallestElementInABST.kthSmallest;

/**
 * Created by Liu on 2020/5/21.
 */
public class TD20_KthSmallestElementInABST_Test {
    public static void main(String[] args) {
        TreeNode root;
        int k;
        int result;
        long startTime;
        long endTime;

        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        k = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(root, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_PermutationInString My 1 result " + result + " during time " + (endTime - startTime));

        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        k = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(root, k);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_PermutationInString My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(TreeNode root, int k) {
        return kthSmallest(root, k);
    }

}
