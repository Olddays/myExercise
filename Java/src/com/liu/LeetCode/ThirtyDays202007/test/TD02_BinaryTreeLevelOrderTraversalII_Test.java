package com.liu.LeetCode.ThirtyDays202007.test;

import com.liu.LeetCode.common.TreeNode;

import java.util.List;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD02_BinaryTreeLevelOrderTraversalII.levelOrderBottom;


/**
 * Created by Liu on 2020/7/2.
 */
public class TD02_BinaryTreeLevelOrderTraversalII_Test {
    public static void main(String[] args) {
        TreeNode root;
        List<List<Integer>> result;
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
        System.out.println("TD02_BinaryTreeLevelOrderTraversalII My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static List<List<Integer>> testMy1(TreeNode root) {
        return levelOrderBottom(root);
    }
}
