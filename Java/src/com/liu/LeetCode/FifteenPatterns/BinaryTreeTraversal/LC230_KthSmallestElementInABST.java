package com.liu.LeetCode.FifteenPatterns.BinaryTreeTraversal;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;

public class LC230_KthSmallestElementInABST {
    // 平衡二叉树，左边比根节点小右边比根节点大，所以找第k个用中序遍历即可
    // accepted 性能中等，因为没必要全部遍历
    private static int kthSmallestMy1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderSearchMy1(root, list, k);
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(k - 1);
    }

    // accepted 性能优，中断遍历
    private static void inOrderSearchMy1(TreeNode root, List<Integer> list, int k) {
        if (root == null) {
            return;
        }
        inOrderSearchMy1(root.left, list, k);
        list.add(root.val);
        inOrderSearchMy1(root.right, list, k);
    }

    private static int kthSmallestMy2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderSearchMy2(root, list, k);
        if (list.isEmpty() || list.size() < k) {
            return -1;
        }
        return list.get(k - 1);
    }

    private static void inOrderSearchMy2(TreeNode root, List<Integer> list, int k) {
        if (root == null) {
            return;
        }
        inOrderSearchMy2(root.left, list, k);
        if (list.size() == k) {
            return;
        } else {
            list.add(root.val);
        }
        inOrderSearchMy2(root.right, list, k);
    }

    public static void main(String[] args) {
        int[][] rootNodeSet = new int[][]{
                {3, 1, 4, Integer.MIN_VALUE, 2},
                {5, 3, 6, 2, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 1},
        };
        int[] kSet = new int[]{
                1,
                3,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = kthSmallestMy1((TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootNodeSet[i]), kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("kthSmallest My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < rootNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = kthSmallestMy2((TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootNodeSet[i]), kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("kthSmallest My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
