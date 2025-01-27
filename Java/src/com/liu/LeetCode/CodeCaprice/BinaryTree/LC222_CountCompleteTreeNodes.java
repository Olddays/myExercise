package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC222_CountCompleteTreeNodes {

    // 任何树都可以用
    private static int countNodesMy1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodesMy1(root.left) + countNodesMy1(root.right) + 1;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {},
                {1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = countNodesMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("countNodes My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
