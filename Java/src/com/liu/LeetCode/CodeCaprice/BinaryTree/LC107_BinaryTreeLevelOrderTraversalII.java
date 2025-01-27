package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC107_BinaryTreeLevelOrderTraversalII {

    private static List<List<Integer>> levelOrderBottomMy1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (!list.isEmpty()) {
                result.add(list);
            }
        }
        int left = 0;
        int right = result.size() - 1;
        while (left < right) {
            List<Integer> list = result.get(left);
            result.set(left, result.get(right));
            result.set(right, list);
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7},
                {1},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = levelOrderBottomMy1(node);
            endTime = System.currentTimeMillis();
            System.out.print("levelOrderBottom My1 result" + i + " ");
            for (List<Integer> list : result) {
                for (int val : list) {
                    System.out.print(val + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
