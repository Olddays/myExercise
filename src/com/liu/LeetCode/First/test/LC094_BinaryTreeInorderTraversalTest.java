package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC094_BinaryTreeInorderTraversal.TreeNode;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC094_BinaryTreeInorderTraversal.getBinaryTreeInorderTraversalMy1;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC094_BinaryTreeInorderTraversalTest {

    public static void main(String[] args) {
        char[] nums = new char[]{
                '1', ' ', '2', '3'
        };
        TreeNode root = new TreeNode(nums[0] - '0');
        TreeNode node = root;
        boolean isLeft = false;
        for (int i = 1; i < nums.length; i++) {
            isLeft = !isLeft;
            char c = nums[i];
            if (c == ' ') {
                continue;
            }
            if (isLeft) {
                node.left = new TreeNode(c - '0');
            } else {
                node.right = new TreeNode(c - '0');
                if (node.left != null) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        long startTime;
        List<Integer> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(root);
        endTime = System.currentTimeMillis();
        System.out.println("BinaryTreeInorderTraversal My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> testMy1(TreeNode root) {
        return getBinaryTreeInorderTraversalMy1(root);
    }
}
