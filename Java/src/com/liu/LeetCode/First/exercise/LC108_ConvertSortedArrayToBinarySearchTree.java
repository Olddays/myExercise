package com.liu.LeetCode.First.exercise;

/**
 * Created by Liu on 2020/6/4.
 */
public class LC108_ConvertSortedArrayToBinarySearchTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            return null;
        }
        int middle = length / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = insertNode(nums, 0, middle);
        root.right = insertNode(nums, middle + 1, length);
        return root;
    }

    private static TreeNode insertNode(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int middle = (end - start) / 2 + start;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = insertNode(nums, start, middle);
        node.right = insertNode(nums, middle + 1, end);
        return node;
    }
}
