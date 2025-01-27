package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class LC104_MaximumDepthOfBinaryTree {
    // 深度就是任意节点到根节点的距离，前序遍历
    // 高度是任意节点到叶子节点的距离，后序遍历，后序遍历就可以实现从下往上遍历，因为最后遍历中，这个题核心是求根节点的高度

    // Beats 12.86%
    private static int maxDepthMy1(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result++;
        }
        return result;
    }

    // 后序遍历
    private static int maxDepthAnswer1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepthAnswer1(root.left); // 左
        int right = maxDepthAnswer1(root.right); // 右
        return 1 + Math.max(left, right); // 中
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7},
                {1, Integer.MIN_VALUE, 2},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = maxDepthMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("maxDepth My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = maxDepthAnswer1(node);
            endTime = System.currentTimeMillis();
            System.out.println("maxDepth Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
