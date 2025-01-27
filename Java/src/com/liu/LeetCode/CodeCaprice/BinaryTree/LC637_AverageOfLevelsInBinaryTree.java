package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC637_AverageOfLevelsInBinaryTree {

    private static List<Double> averageOfLevelsMy1(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            double size = queue.size(); // 用double 避免int导致溢出
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {2147483647, 2147483647, 2147483647},
                {3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7},
                {3, 9, 20, 15, 7},
        };
        List<Double> result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = averageOfLevelsMy1(node);
            endTime = System.currentTimeMillis();
            System.out.print("averageOfLevels My1 result" + i + " ");
            for (double val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
