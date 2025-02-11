package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.tools.Utils;

public class LC108_ConvertSortedArrayToBinarySearchTree {

    private static TreeNode sortedArrayToBSTMy1(int[] nums) {
        return sortedArrayToBSTMy1Helper(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTMy1Helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTMy1Helper(nums, start, mid - 1);
        root.right = sortedArrayToBSTMy1Helper(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {-10, -3, 0, 5, 9},
                {1, 3},
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = sortedArrayToBSTMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("sortedArrayToBST My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
