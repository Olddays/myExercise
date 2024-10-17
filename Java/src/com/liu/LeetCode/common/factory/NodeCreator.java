package com.liu.LeetCode.common.factory;

import com.liu.LeetCode.common.bean.BaseNode;
import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.bean.Node;
import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            case NODE_TYPE_PREORDER_BINARY_TREE_ROOT:
                return createBinaryTreeNodeWithPreOrder(values);
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

    private static TreeNode createBinaryTreeNodeWithPreOrder(int[] values) {
        TreeNode root = new TreeNode(values[0]);
        TreeNode node = root;
        boolean isLeft = false;
        int jumpCount = 0;
        for (int i = 1; i < values.length; i++) {
            isLeft = !isLeft;
            int c = values[i];
            if (c == Integer.MIN_VALUE || c == Integer.MAX_VALUE) {
                jumpCount++;
                continue; // 跳过
            }
            if (isLeft) {
                node.left = new TreeNode(c);
            } else {
                node.right = new TreeNode(c);
                if (node.left != null && jumpCount % 2 != 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            jumpCount = 0;
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
