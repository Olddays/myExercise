package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC501_FindModeInBinarySearchTree {
    // 遍历方法，非最优 Beats 33.72%
    private static int[] findModeMy1(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        searchModeMy1Helper(root, map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int max = list.get(list.size() - 1).getValue();
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private static void searchModeMy1Helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        searchModeMy1Helper(root.left, map);
        searchModeMy1Helper(root.right, map);
    }

    // Beats 100.00%
    // 搜索二叉树双指针，需要好几个全局变量
    private static TreeNode preNode; // 前一个节点
    private static int count = 0; // 当前量
    private static int maxCount = 0; // 最高频

    private static int[] findModeMy2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversalNodeMy2(root, result);
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private static void traversalNodeMy2(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        traversalNodeMy2(node.left, result);
        if (preNode == null) { // 第一个节点
            count = 1;
        } else if (preNode.val == node.val) {
            count++;
        } else {
            count = 1;
        }
        preNode = node;
        if (count == maxCount) {
            result.add(node.val);
        } else if (count > maxCount) {
            maxCount = count;
            result.clear(); // 旧的数据时错的，所以清空
            result.add(node.val);
        }
        traversalNodeMy2(node.right, result);
    }

    public static void main(String[] args) {
        int[][] rootSet = new int[][]{
                {1, Integer.MIN_VALUE, 2, 2},
                {0},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            startTime = System.currentTimeMillis();
            result = findModeMy1(node);
            endTime = System.currentTimeMillis();
            System.out.print("findMode My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < rootSet.length; i++) {
            preNode = null;
            count = 0;
            maxCount = 0;
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            startTime = System.currentTimeMillis();
            result = findModeMy2(node);
            endTime = System.currentTimeMillis();
            System.out.print("findMode My2 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
