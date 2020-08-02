package com.liu.LeetCode.First.test;

import com.liu.LeetCode.common.TreeNode;

import static com.liu.LeetCode.First.exercise.LC508_MostFrequentSubtreeSum.getMostFrequentSubtreeSumAnswer1;

/**
 * Created by liu on 2017/9/14.
 */
public class LC508_MostFrequentSubtreeSumTest {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(-3);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(-5);

        TreeNode[] inputs = {
                root1, root2
        };

        long startTime;
        int[] result;
        long endTime;
        for (TreeNode root : inputs) {
            startTime = System.currentTimeMillis();
            result = testMy1(root);
            endTime = System.currentTimeMillis();
            System.out.println("MostFrequentSubtreeSum Answer 1 result.length " + result.length + " during time " + (endTime - startTime));
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[] testMy1(TreeNode root) {
        return getMostFrequentSubtreeSumAnswer1(root);
    }
}
