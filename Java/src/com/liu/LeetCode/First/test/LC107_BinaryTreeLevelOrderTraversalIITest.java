package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC107_BinaryTreeLevelOrderTraversalII.TreeNode;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC107_BinaryTreeLevelOrderTraversalII.levelOrderBottom;

public class LC107_BinaryTreeLevelOrderTraversalIITest {
    public static void main(String[] args) {
        List<List<Integer>> result;
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
        System.out.println("BinaryTreeLevelOrderTraversalII My 1, during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> testMy1(TreeNode node) {
        return levelOrderBottom(node);
    }

}
