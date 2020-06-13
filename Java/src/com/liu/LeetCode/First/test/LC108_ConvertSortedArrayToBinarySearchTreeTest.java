package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC108_ConvertSortedArrayToBinarySearchTree.TreeNode;

import static com.liu.LeetCode.First.exercise.LC108_ConvertSortedArrayToBinarySearchTree.sortedArrayToBST;

/**
 * Created by Liu on 2020/6/4.
 */
public class LC108_ConvertSortedArrayToBinarySearchTreeTest {
    public static void main(String[] args) {
        int[] nums;
        TreeNode result;
        long startTime;
        long endTime;

        nums = new int[]{
                -10, -3, 0, 5, 9
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD04_ReverseString My 1 result " + result + " during time " + (endTime - startTime));
        preorderPrint(result);
        System.out.println();

    }

    private static void preorderPrint(TreeNode result) {
        if (result != null) {
            System.out.print(result.val + " ");
            preorderPrint(result.left);
            preorderPrint(result.right);
        }
    }

    private static TreeNode testMy1(int[] nums) {
        return sortedArrayToBST(nums);
    }
}
