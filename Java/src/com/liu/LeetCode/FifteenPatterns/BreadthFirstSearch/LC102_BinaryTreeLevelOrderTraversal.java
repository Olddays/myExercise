package com.liu.LeetCode.FifteenPatterns.BreadthFirstSearch;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Breadth-First Search (BFS) is a traversal technique that explores nodes level by level in a tree or graph.
 * Use this pattern for finding the shortest paths in unweighted graphs or level-order traversal in trees.
 * Sample Problem:
 * Perform level-order traversal of a binary tree.
 * Example:
 * Input: root = [3, 9, 20, null, null, 15, 7]
 * Output: [[3], [9, 20], [15, 7]]
 * Explanation:
 * Use a queue to keep track of nodes at each level.
 * Traverse each level and add the children of the current nodes to the queue.
 */
public class LC102_BinaryTreeLevelOrderTraversal {

    private static List<List<Integer>> levelOrderMy1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        breadthFirstSearchMy1(root, result, 0);
        return result;
    }

    private static void breadthFirstSearchMy1(TreeNode root, List<List<Integer>> result, int layer) {
        if (layer == result.size()) { // 刚进入这一层
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
        } else {
            List<Integer> list = result.get(layer);
            list.add(root.val);
            result.set(layer, list);
        }
        if (root.left != null) {
            breadthFirstSearchMy1(root.left, result, layer + 1);
        }
        if (root.right != null) {
            breadthFirstSearchMy1(root.right, result, layer + 1);
        }
    }

    public static void main(String[] args) {
        int[][] treeNodeSet = new int[][]{
                {3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 17},
                {1},
                {},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < treeNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = levelOrderMy1((TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_PREORDER_BINARY_TREE_ROOT, treeNodeSet[i]));
            endTime = System.currentTimeMillis();
            System.out.print("levelOrder My1 result" + i + " ");
            for (List<Integer> numSet : result) {
                for (int num : numSet) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
