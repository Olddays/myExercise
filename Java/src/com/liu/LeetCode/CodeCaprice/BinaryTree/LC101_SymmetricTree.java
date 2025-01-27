package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 做二叉树的题目的时候，一定要想清楚该用什么顺序遍历，时先序（中左右）、中序（左中右）还是后序（左右中），以及为什么
// 比如这个是否对称就应该用后续，因为时左右中，比较完左右再读中间（做操作）
public class LC101_SymmetricTree {
    // Beats 14.00%
    private static boolean isSymmetricMy1(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
                if (node == null) {
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                TreeNode left = list.get(i);
                TreeNode right = list.get(j);
                if (left != null && right != null) {
                    if (left.val != right.val) {
                        return false;
                    }
                } else if (left != null || right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    // Beats 100%
    private static boolean isSymmetricMy2(TreeNode root) {
        if (root == null) {
            return false;
        }
        return checkLeftRightMy2(root.left, root.right);
    }

    private static boolean checkLeftRightMy2(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        // 轴对称
        return checkLeftRightMy2(left.left, right.right) && checkLeftRightMy2(left.right, right.left);
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 0},
                {1, 2, 2, 3, 4, 4, 3},
                {1, 2, 2, Integer.MIN_VALUE, 3, Integer.MIN_VALUE, 3},
                {1, 2, 2, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, 3},
                {1},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = isSymmetricMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("isSymmetric My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = isSymmetricMy2(node);
            endTime = System.currentTimeMillis();
            System.out.println("isSymmetric My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
