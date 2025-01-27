package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class LC513_FindBottomLeftTreeValue {

    // Beats 57.51%
    private static int findBottomLeftValueMy1(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node == null) {
                continue;
            }
            result = node.val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    // Beats 77.38%
    private static int findBottomLeftValueMy2(TreeNode root) {
        int[] result = findBottomLeftValueHelperMy2(root, 0);
        if (result.length > 0) {
            return result[0];
        }
        return 0;
    }

    private static int[] findBottomLeftValueHelperMy2(TreeNode root, int depth) {
        if (root == null) {
            return new int[0];
        }
        int[] left = findBottomLeftValueHelperMy2(root.left, depth + 1);
        int[] right = findBottomLeftValueHelperMy2(root.right, depth + 1);
        if (left.length > 0 && right.length > 0) {
            if (left[1] >= right[1]) {
                return left;
            } else {
                return right;
            }
        } else if (left.length > 0) {
            return left;
        } else if (right.length > 0) {
            return right;
        } else {
            return new int[]{root.val, depth};
        }
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7},
                {0, Integer.MIN_VALUE, -1},
                {1, 2, 3, 4, Integer.MIN_VALUE, 5, 6, Integer.MIN_VALUE, Integer.MIN_VALUE, 7},
                {1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = findBottomLeftValueMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("findBottomLeftValue My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = findBottomLeftValueMy2(node);
            endTime = System.currentTimeMillis();
            System.out.println("findBottomLeftValue My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
