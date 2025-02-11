package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC617_MergeTwoBinaryTrees {

    // 既然是合并，那我觉得应该用中序遍历
    private static TreeNode mergeTreesMy1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTreesMy1(root1.left, root2.left);
        root1.right = mergeTreesMy1(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        int[][] root1Set = new int[][]{
                {1, 3, 2, 5},
                {1},
        };
        int[][] root2Set = new int[][]{
                {2, 1, 3, Integer.MIN_VALUE, 4, Integer.MIN_VALUE, 7},
                {1, 2},
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < root1Set.length; i++) {
            TreeNode node1 = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, root1Set[i]);
            TreeNode node2 = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, root2Set[i]);
            startTime = System.currentTimeMillis();
            result = mergeTreesMy1(node1, node2);
            endTime = System.currentTimeMillis();
            System.out.println("mergeTrees My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
