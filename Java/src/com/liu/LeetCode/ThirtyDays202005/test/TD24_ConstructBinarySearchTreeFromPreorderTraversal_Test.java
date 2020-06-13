package com.liu.LeetCode.ThirtyDays202005.test;

import com.liu.LeetCode.ThirtyDays202005.exercise.TD24_ConstructBinarySearchTreeFromPreorderTraversal.TreeNode;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD24_ConstructBinarySearchTreeFromPreorderTraversal.bstFromPreorder;

/**
 * Created by Liu on 2020/5/28.
 */
public class TD24_ConstructBinarySearchTreeFromPreorderTraversal_Test {

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {8, 5, 1, 7, 10, 12}
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int[] nums : numsList) {
            startTime = System.currentTimeMillis();
            result = testMy1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("TD24_ConstructBinarySearchTreeFromPreorderTraversal My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static TreeNode testMy1(int[] nums) {
        return bstFromPreorder(nums);
    }
}
