package com.liu.LeetCode.common.tools;

import com.liu.LeetCode.common.bean.BaseNode;
import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.bean.Node;
import com.liu.LeetCode.common.bean.TreeNode;

import java.util.*;

public class Utils {
    public enum NODE_TYPE {
        NODE_TYPE_NORMAL_LIST,
        NODE_TYPE_CYCLE_LIST,
        NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT,
        NODE_TYPE_LEVEL_ORDER_NORMAL_TREE_ROOT,
        NODE_TYPE_LEVEL_ORDER_NEIGHBOUR_BINARY_TREE_ROOT,
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
            case NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT:
                return createBinaryTreeNodeLog(node);
            case NODE_TYPE_LEVEL_ORDER_NORMAL_TREE_ROOT:
                return createNormalTreeNodeLog(node);
            case NODE_TYPE_LEVEL_ORDER_NEIGHBOUR_BINARY_TREE_ROOT:
                return createNeighbourBinaryTreeNodeLog(node);
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
            point = point.next;
            if (cache.containsKey(point)) {
                sb.append("cycle on ").append(cache.get(point)).append(",");
                break;
            } else {
                sb.append(point.val).append(",");
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

    private static String createNormalTreeNodeLog(BaseNode node) {
        StringBuilder sb = new StringBuilder();
        Node point = (Node) node;
        deepFirstSearch(point, sb);
        return sb.toString();
    }

    private static String createNeighbourBinaryTreeNodeLog(BaseNode node) {
        StringBuilder sb = new StringBuilder();
        Node point = (Node) node;
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
        for (Node child : node.children) {
            deepFirstSearch(child, sb);
        }
        if (node.left != null) {
            deepFirstSearch(node.left, sb);
        }
        if (node.right != null) {
            deepFirstSearch(node.right, sb);
        }
        if (node.next != null) {
            deepFirstSearch(node.next, sb);
        }
    }

    public static boolean compareResult(int result, int expected) {
        return result == expected;
    }

    public static boolean compareResult(long result, long expected) {
        return result == expected;
    }

    public static boolean compareResult(float result, float expected) {
        return result == expected;
    }

    public static boolean compareResult(double result, double expected) {
        return result == expected;
    }

    public static boolean compareResult(boolean result, boolean expected) {
        return result == expected;
    }

    public static boolean compareResult(String result, String expected) {
        return result.equals(expected);
    }

    public static boolean compareResult(int[] result, int[] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != expected[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareResult(long[] result, long[] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != expected[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareResult(float[] result, float[] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != expected[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareResult(double[] result, double[] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != expected[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareResult(boolean[] result, boolean[] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != expected[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareResult(String[] result, String[] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (!result[i].equals(expected[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareResult(int[][] result, int[][] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i].length != expected[i].length) {
                return false;
            }
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean compareResult(long[][] result, long[][] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i].length != expected[i].length) {
                return false;
            }
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean compareResult(float[][] result, float[][] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i].length != expected[i].length) {
                return false;
            }
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean compareResult(double[][] result, double[][] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i].length != expected[i].length) {
                return false;
            }
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean compareResult(boolean[][] result, boolean[][] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i].length != expected[i].length) {
                return false;
            }
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean compareResult(String[][] result, String[][] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i].length != expected[i].length) {
                return false;
            }
            for (int j = 0; j < result[i].length; j++) {
                if (!result[i][j].equals(expected[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean compareResult(List result, List expected) {
        if (result.size() != expected.size()) {
            return false;
        }
        for (int i = 0; i < result.size(); i++) {
            if (!result.get(i).equals(expected.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareResult(Set result, Set expected) {
        return result.size() == expected.size() && result.containsAll(expected);
    }

    public static boolean compareResult(Map result, Map expected) {
        if (result.size() != expected.size()) {
            return false;
        }
        for (Object object : result.entrySet()) {
            Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) object;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!expected.containsKey(key) || !value.equals(expected.get(key))) {
                return false;
            }
        }
        return true;
    }
}
