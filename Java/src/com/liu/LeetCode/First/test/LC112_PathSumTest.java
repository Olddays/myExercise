package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC112_PathSum.TreeNode;

import static com.liu.LeetCode.First.exercise.LC112_PathSum.hasPathSum;

/**
 * Created by Liu on 2020/6/12.
 */
public class LC112_PathSumTest {

    public static void main(String[] args) {
        TreeNode root;
        int sum;
        boolean result;
        long startTime;
        long endTime;

        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        sum = 22;
        startTime = System.currentTimeMillis();
        result = testMy1(root, sum);
        endTime = System.currentTimeMillis();
        System.out.println("MinimumDepthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        sum = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(root, sum);
        endTime = System.currentTimeMillis();
        System.out.println("MinimumDepthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static boolean testMy1(TreeNode root, int sum) {
        return hasPathSum(root, sum);
    }

}
