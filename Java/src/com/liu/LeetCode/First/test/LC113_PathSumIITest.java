package com.liu.LeetCode.First.test;

import com.liu.LeetCode.common.TreeNode;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC113_PathSumII.pathSum;

/**
 * Created by Liu on 2020/6/23.
 */
public class LC113_PathSumIITest {
    public static void main(String[] args) {
        TreeNode root;
        int sum;
        List<List<Integer>> result;
        long startTime;
        long endTime;


        root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        sum = -5;
        startTime = System.currentTimeMillis();
        result = testMy1(root, sum);
        endTime = System.currentTimeMillis();
        System.out.println("MinimumDepthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();

        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        sum = 22;
        startTime = System.currentTimeMillis();
        result = testMy1(root, sum);
        endTime = System.currentTimeMillis();
        System.out.println("MinimumDepthOfBinaryTree My 1 result " + result + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<List<Integer>> testMy1(TreeNode root, int sum) {
        return pathSum(root, sum);
    }

}
