package com.liu.LeetCode.common.factory;

import com.liu.LeetCode.common.bean.BaseNode;
import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.bean.Node;
import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class NodeCreator {
    public static BaseNode createNode(Utils.NODE_TYPE nodeType, int[] values, int... args) {
        if (values.length == 0) {
            return null;
        }
        switch (nodeType) {
            case NODE_TYPE_NORMAL_LIST:
                return createNormalListNode(values);
            case NODE_TYPE_CYCLE_LIST:
                return createCycleListNode(values, args);
            case NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT:
                return createBinaryTreeNodeWithLevelOrder(values);
            case NODE_TYPE_LEVEL_ORDER_NORMAL_TREE_ROOT:
                return createNormalTreeNodeWithLevelOrder(values);
            case NODE_TYPE_LEVEL_ORDER_NEIGHBOUR_BINARY_TREE_ROOT:
                return createNeighbourBinaryTreeNodeWithLevelOrder(values);
            default:
                return null;
        }
    }

    private static ListNode createNormalListNode(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode point = head;
        for (int i = 1; i < values.length; i++) {
            point.next = new ListNode(values[i]);
            point = point.next;
        }
        return head;
    }

    private static ListNode createCycleListNode(int[] values, int[] args) {
        ListNode head = new ListNode(values[0]);
        ListNode point = head;
        ListNode positionNode = null;
        int position = args[0];
        if (position == 0) {
            positionNode = head;
        }
        for (int i = 1; i < values.length; i++) {
            point.next = new ListNode(values[i]);
            point = point.next;
            if (i == position) {
                positionNode = point;
            }
        }
        point.next = positionNode;
        return head;
    }

    private static TreeNode createBinaryTreeNodeWithLevelOrder(int[] values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>(); // 所以使用queue，针对queue顶操作，完成一个子孩子就退出
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode currentNode = queue.poll();
            for (int i = 0; i < 2 && index < values.length; i++) {
                int value = values[index];
                if (value != Integer.MIN_VALUE && value != Integer.MAX_VALUE) {
                    if (i == 0) {
                        currentNode.left = new TreeNode(value);
                        queue.add(currentNode.left);
                    } else {
                        currentNode.right = new TreeNode(value);
                        queue.add(currentNode.right);
                    }
                }
                index++;
            }
        }
        return root;
    }

    private static Node createNormalTreeNodeWithLevelOrder(int[] values) {
        Node root = new Node(values[0]);
        // 输入数据类似[1,null,3,2,4,null,5,6]，每个null表示按照逐行遍历的方式当前这个孩子的子孩子结束
        // 所以从1开始
        Queue<Node> queue = new LinkedList<>(); // 所以使用queue，针对queue顶操作，完成一个子孩子就退出
        queue.add(root);
        Node currentNode = null;
        for (int i = 1; i < values.length; i++) {
            int c = values[i];
            if (c == Integer.MIN_VALUE || c == Integer.MAX_VALUE) {
                currentNode = queue.poll();
                continue;
            }
            if (currentNode == null) {
                System.out.println("create node error");
                return null;
            }
            Node newNode = new Node(c);
            queue.add(newNode);
            currentNode.children.add(newNode);
        }
        return root;
    }

    private static Node createNeighbourBinaryTreeNodeWithLevelOrder(int[] values) {
        Node root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>(); // 所以使用queue，针对queue顶操作，完成一个子孩子就退出
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            Node currentNode = queue.poll();
            for (int i = 0; i < 2; i++) {
                int value = values[index];
                if (value != Integer.MIN_VALUE && value != Integer.MAX_VALUE) {
                    if (i == 0) {
                        currentNode.left = new Node(value);
                        queue.add(currentNode.left);
                    } else {
                        currentNode.right = new Node(value);
                        queue.add(currentNode.right);
                    }
                }
                index++;
            }
        }
        return root;
    }

    public static Node createNormalNode(int[][] values) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i < values.length + 1; i++) {
            Node node = new Node(i);
            map.put(i, node);
        }
        for (int i = 0; i < values.length; i++) {
            Node node = map.get(i + 1);
            int[] neighbors = values[i];
            for (int neighbor : neighbors) {
                node.neighbors.add(map.get(neighbor));
            }
        }
        if (!map.isEmpty()) {
            return map.get(1);
        }
        return null;
    }
}
