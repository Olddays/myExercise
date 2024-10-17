package com.liu.LeetCode.common.tools;

import com.liu.LeetCode.common.bean.BaseNode;
import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.bean.Node;
import com.liu.LeetCode.common.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public enum NODE_TYPE {
        NODE_TYPE_NORMAL_LIST,
        NODE_TYPE_CYCLE_LIST,
        NODE_TYPE_PREORDER_BINARY_TREE_ROOT,
        NODE_TYPE_NORMAL,
    }

    public enum TEST_RESULT_TYPE {
        NODE_TYPE_NORMAL,
        NODE_TYPE_LIST,
        NODE_TYPE_NODE
    }

    public interface TestFunction<T> {
        void runFunctionTest(T t);
    }

    public static <T> void runTestWithPrint(TEST_RESULT_TYPE resultType, T obj, TestFunction<T> function) {
    }

    public static String getNodePrintableLog(NODE_TYPE nodeType, BaseNode node, int... args) {
        if (node == null) {
            return "null node";
        }
        switch (nodeType) {
            case NODE_TYPE_NORMAL_LIST:
                return createNormalListNodeLog(node);
            case NODE_TYPE_CYCLE_LIST:
                return createCycleListNodeLog(node);
            case NODE_TYPE_PREORDER_BINARY_TREE_ROOT:
                return createBinaryTreeNodeLog(node);
            case NODE_TYPE_NORMAL:
                return createNormalNodeLog(node);
            default:
                return null;
        }
    }

    private static String createNormalListNodeLog(BaseNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode point = (ListNode) node;
        while (point != null) {
            sb.append(point.val).append(",");
            point = point.next;
        }
        return sb.toString();
    }

    private static String createCycleListNodeLog(BaseNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode point = (ListNode) node;
        Map<ListNode, Integer> cache = new HashMap<>();
        int index = 0;
        while (point != null) {
            sb.append(point.val).append(",");
            point = point.next;
            if (cache.containsKey(point)) {
                sb.append("cycle on ").append(cache.get(point)).append(",");
                break;
            } else {
                cache.put(point, index);
                index++;
            }
        }
        return sb.toString();
    }

    private static String createBinaryTreeNodeLog(BaseNode node) {
        StringBuilder sb = new StringBuilder();
        TreeNode point = (TreeNode) node;
        deepFirstSearch(point, sb);
        return sb.toString();
    }

    private static String createNormalNodeLog(BaseNode node) {
        StringBuilder sb = new StringBuilder();
        Node point = (Node) node;
        deepFirstSearch(point, sb);
        return sb.toString();
    }

    private static void deepFirstSearch(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val).append(",");
        deepFirstSearch(node.left, sb);
        deepFirstSearch(node.right, sb);
    }

    private static void deepFirstSearch(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val).append(",");
        for (Node child : node.neighbors) {
            deepFirstSearch(child, sb);
        }
    }
}
