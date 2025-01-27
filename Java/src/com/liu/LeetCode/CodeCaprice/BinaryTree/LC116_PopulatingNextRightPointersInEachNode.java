package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.Node;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class LC116_PopulatingNextRightPointersInEachNode {

    // Beats 51.55%
    private static Node connectMy1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node lastNode = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (lastNode != null) {
                    lastNode.next = node;
                }
                lastNode = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    // Beats 100%
    private static Node connectMy2(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connectMy2(root.left);
        connectMy2(root.right);
        return root;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2, 3, 4, 5, 6, 7},
        };
        Node result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            Node node = (Node) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_NEIGHBOUR_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = connectMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("connect My1 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_NEIGHBOUR_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            Node node = (Node) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_NEIGHBOUR_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = connectMy2(node);
            endTime = System.currentTimeMillis();
            System.out.println("connect My2 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_NEIGHBOUR_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
