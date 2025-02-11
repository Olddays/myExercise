package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC654_MaximumBinaryTree {

    // Beats 62.68%
    private static TreeNode constructMaximumBinaryTreeMy1(int[] nums) {
        return constructMaximumBinaryTreeHelperMy1(nums, 0, nums.length - 1);
    }

    private static TreeNode constructMaximumBinaryTreeHelperMy1(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 构造二叉树一定要用前序，因为要先构造中，才能给中赋值左和右
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTreeHelperMy1(nums, start, index - 1);
        root.right = constructMaximumBinaryTreeHelperMy1(nums, index + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {3, 2, 1, 6, 0, 5},
                {3, 2, 1},
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = constructMaximumBinaryTreeMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("constructMaximumBinaryTree My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
