package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC404_SumOfLeftLeaves {

    // 乍一看求左叶子，那就用中序，左中右
    // 但是应该用后序，求叶子要先一路找到最底下，通过输入一个isLeft来判断是不是左叶子
    // 因为左叶子是靠是不是父节点的左孩子，并且自己左右孩子都空才行
    private static int sumOfLeftLeavesMy1(TreeNode root) {
        return sumOfLeftLeavesHelperMy1(root, false);
    }

    private static int sumOfLeftLeavesHelperMy1(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int left = sumOfLeftLeavesHelperMy1(root.left, true);
        int right = sumOfLeftLeavesHelperMy1(root.right, false);
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        return left + right;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7},
                {1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = sumOfLeftLeavesMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("sumOfLeftLeaves My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
