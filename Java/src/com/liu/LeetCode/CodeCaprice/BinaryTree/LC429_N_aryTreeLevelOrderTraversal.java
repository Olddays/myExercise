package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.Node;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC429_N_aryTreeLevelOrderTraversal {

    private static List<List<Integer>> levelOrderMy1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, Integer.MIN_VALUE, 3, 2, 4, Integer.MIN_VALUE, 5, 6},
                {1, Integer.MIN_VALUE, 2, 3, 4, 5, Integer.MIN_VALUE, Integer.MIN_VALUE, 6, 7, Integer.MIN_VALUE, 8, Integer.MIN_VALUE, 9, 10, Integer.MIN_VALUE, Integer.MIN_VALUE, 11, Integer.MIN_VALUE, 12, Integer.MIN_VALUE, 13, Integer.MIN_VALUE, Integer.MIN_VALUE, 14},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            Node node = (Node) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_NORMAL_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = levelOrderMy1(node);
            endTime = System.currentTimeMillis();
            System.out.print("levelOrder My1 result" + i + " ");
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
